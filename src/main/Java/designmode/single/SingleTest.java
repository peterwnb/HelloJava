package designmode.single;

/**
 * Created by zzqno on 2017-2-26.
 */
public class SingleTest {

    private SingleTest() {}

    private static SingleTest test;

    public static synchronized SingleTest getSingleTest() {
        if (test == null)
            return new SingleTest();
        else
            return test;
    }

    public static void main(String[] args) {

        SingleTest test = SingleTest.getSingleTest();
        SingleTest test1 = SingleTest.getSingleTest();
        System.out.println(test == test1);
    }
}