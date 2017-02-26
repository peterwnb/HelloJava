package designmode.single;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by zzqno on 2017-2-26.
 */
public class SingleTest1 {

    private SingleTest1() {}

    private static ReentrantLock lock = new ReentrantLock();
    private static SingleTest1 singleTest1;


    public static SingleTest1 getSingleTest() {
        if (singleTest1 == null) {
            lock.lock();
            singleTest1 = new SingleTest1();
            lock.unlock();
        }
        return singleTest1;
    }

    public static void main(String[] args) {
        SingleTest1 test = SingleTest1.getSingleTest();
        SingleTest1 test1 = SingleTest1.getSingleTest();
        System.out.println(test == test1);
    }
}
