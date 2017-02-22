package thread.lock;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zzq on 16-10-26.
 */
public class ThreadA extends Thread {
    private Count count;

    public ThreadA(Count count) {
        this.count = count;
    }

    @Override
    public void run() {
        count.add();
    }

    public static void main(String[] args) {
        List<ThreadA> list = new ArrayList<ThreadA>();
        Count count = new Count();
        for (int i = 0; i < 5; i++) {
            ThreadA task = new ThreadA(count);
            task.start();
            list.add(task);
        }
        try {
            for (Thread thread : list) {
                thread.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("5个人干完活：最后的值是" + count.num);
    }
}
