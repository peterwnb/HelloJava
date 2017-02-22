package thread.createthread;

import java.util.concurrent.Callable;

/**
 * Created by monster_zzq on 2016/7/4.
 */
public class CreateThread implements Callable<String>{

    public String call() {
        try {
            System.out.println("休眠开始 ....");
            Thread.sleep(3000);
            System.out.println("休眠结束 ....");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("线程结束...");
        return "call()";
    }
}
