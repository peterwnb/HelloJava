package thread.createthread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Created by monster_zzq on 2016/7/5.
 */
public class ThreadMain {

    public static void main(String[] args) {
        CreateThread createThread = new CreateThread();
        FutureTask<String> futureTask = new FutureTask<String>(createThread);
        new Thread(futureTask).start();
        System.out.println("主线程 begin!!!");
      try {
            //调用get方法 主线程阻塞执行。否则异步。
            //get()得到call()方法返回的结果
            System.out.println(futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("主线程 end !!!");
    }
}
