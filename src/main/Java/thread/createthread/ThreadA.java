package thread.createthread;

/**
 * Created by monster_zzq on 2016/7/5.
 */
public class ThreadA implements Runnable{

    public void run() {
        try {
            System.out.println("休眠开始 ....");
            Thread.sleep(3000);
            System.out.println("休眠结束 ....");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
