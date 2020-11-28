package az.task.executor;

import java.util.Comparator;
import java.util.Set;
import java.util.concurrent.*;

public class WorkflowExecutor {

    private static final ExecutorService EXECUTOR_SERVICE = Executors.newCachedThreadPool();

    public static <RequestObject, ResponseObject> ResponseObject execute(AbstractWorkflow<ResponseObject> abstractWorkflow, RequestObject request) {
        if (abstractWorkflow == null || abstractWorkflow.getTaskSets() == null) {
            throw new IllegalArgumentException("workflow object and task set can't be null");
        }
        ResponseObject response = null;
        ConcurrentHashMap<AbstractTask, Object> map = new ConcurrentHashMap<>();
        for (Set<AbstractTask> taskSet : abstractWorkflow.getTaskSets()) {
            try {
                if (!taskSet.isEmpty()) {
                    long maxTime = taskSet.stream().max(Comparator.comparingLong(AbstractTask::getTimeOfExecutionInMillis)).get().getTimeOfExecutionInMillis();
                    long totalTime = taskSet.stream().mapToLong(AbstractTask::getTimeOfExecutionInMillis).sum();
                    System.out.println("set will finish in : " + maxTime + " milliseconds" + " totalTime : " + totalTime);
                    long startTime = System.currentTimeMillis();
                    CountDownLatch latch = new CountDownLatch(taskSet.size());
                    for (AbstractTask task : taskSet) {
                        EXECUTOR_SERVICE.execute(() -> task.execute(map, request, latch));
                    }
                    latch.await(maxTime, TimeUnit.MILLISECONDS);
                    System.out.println("time taken to finish : " + (System.currentTimeMillis() - startTime));
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        response = abstractWorkflow.aggregateResponse(map);
        return response;
    }


    public static void shutdown() {
        EXECUTOR_SERVICE.shutdownNow();
    }

}
