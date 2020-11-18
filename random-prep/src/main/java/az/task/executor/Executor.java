package az.task.executor;


import com.ds.utils.NumberUtils;

public class Executor {

    public static void main(String[] args) {

        Workflow workflow = new Workflow() {
        };

        for (int i = 0; i < 100; i++) {
            int index = i;
            workflow.addTask(new AbstractTask() {

                private final long time = NumberUtils.getRandomInt(100, 200);

                @Override
                public long getTimeOfExecutionInMillis() {
                    return time;
                }

                @Override
                public boolean isRunnable() {
                    return true;
                }

                @Override
                public void process() {
                    try {
                        Thread.sleep(time);
                    } catch (InterruptedException ignored) {
                    }
                    System.out.println("Task : " + index);
                }
            }, NumberUtils.getRandomInt(0, 5));
        }

        WorkflowExecutor.execute(workflow);
        WorkflowExecutor.shutdown();

    }


}
