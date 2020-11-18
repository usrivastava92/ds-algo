package az.task.executor;

import java.util.Comparator;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WorkflowExecutor {

    private static final ExecutorService EXECUTOR_SERVICE = Executors.newCachedThreadPool();

    public static void execute(Workflow workflow) {
        for (Set<AbstractTask> taskSet : workflow.getTaskSets()) {
            try {
                long maxTime = taskSet.stream().max(Comparator.comparingLong(AbstractTask::getTimeOfExecutionInMillis)).get().getTimeOfExecutionInMillis();
                long totalTime = taskSet.stream().mapToLong(AbstractTask::getTimeOfExecutionInMillis).sum();
                System.out.println("set will finish in : " + maxTime + " milliseconds" + " totalTime : " + totalTime);
                long startTime = System.currentTimeMillis();
                CountDownLatch latch = new CountDownLatch(taskSet.size());
                for (AbstractTask task : taskSet) {
                    EXECUTOR_SERVICE.execute(task);
                }
                latch.await(maxTime, TimeUnit.MILLISECONDS);
                System.out.println("time taken to finish : " + (System.currentTimeMillis() - startTime));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("#############################################");
        }
    }


    public static void shutdown() {
        EXECUTOR_SERVICE.shutdownNow();
    }

}
