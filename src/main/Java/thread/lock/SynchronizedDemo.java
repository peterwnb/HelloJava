package thread.lock;

/**
 * Created by monster_zzq on 2016/7/19.
 */
public class SynchronizedDemo {
    private int num = 10;

    public synchronized int add() {
        num++;
        return num;
    }

    public synchronized int minus() {
        num--;
        return num;
    }
}


class Test implements Runnable{
    private SynchronizedDemo synchronizedDemo = new SynchronizedDemo();

    @Override
    public void run() {
        synchronizedDemo.add();
    }
}
