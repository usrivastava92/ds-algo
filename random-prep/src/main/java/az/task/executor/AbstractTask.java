package az.task.executor;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;

public abstract class AbstractTask<RequestObject, ResponseObject> {

    public void execute(ConcurrentHashMap<AbstractTask<RequestObject, ResponseObject>, Object> map, RequestObject request, CountDownLatch latch) {
        try {
            if (isRunnable(request)) {
                map.put(this, process(request));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            latch.countDown();
        }
    }

    public abstract String getName();

    public abstract long getTimeOfExecutionInMillis();

    public abstract boolean isRunnable(RequestObject request);

    public abstract ResponseObject process(RequestObject request);

}
