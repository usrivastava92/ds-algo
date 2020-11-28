package az.multithreading;

public class ThreadUtils {

    private ThreadUtils(){

    }

    public static void sleep(long millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
