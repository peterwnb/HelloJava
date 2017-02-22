package thread.interrupt;

/**
 * Created by monster_zzq on 2016/7/8.
 */
public class TestThreadInterrupt extends Thread{

    @Override
    public void run() {
        boolean stop = false;
        while (!stop){
            System.out.println(" thread running");
            if (isInterrupted()) {
                System.out.println(" thread interrupt ....");
                return;
            }
        }
    }


    public static void main(String[] args) {
        Thread thread = new TestThreadInterrupt();
        thread.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
    }
}
