package az.task.executor;

import java.time.Duration;

public abstract class AbstractTask implements Runnable {

    @Override
    public void run() {
        if (isRunnable()) {
            process();
        }
    }

    public abstract long getTimeOfExecutionInMillis();

    public abstract boolean isRunnable();

    public abstract void process();

}
