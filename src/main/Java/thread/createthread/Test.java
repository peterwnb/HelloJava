package thread.createthread;

/**
 * Created by monster_zzq on 2016/7/14.
 */
public class Test extends Thread {
    @Override
    public void run() {
        while ( true ) {
            System.out.println(" ----------1 -------");
        }
    }

    public static void main(String[] args) {
        Test test = new Test();
        test.start();
        try {
            System.out.println(" test wait ... ");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("theadmain over ... ");
    }
}
