package nio.niosocket;

/**
 * Created by zzqno on 2017-4-13.
 */
public class TimeClient {
    public static void main(String[] args) {
        int port = 8088;
        new Thread(new TimeClientHandle("127.0.0.1",port),"TimeClient--001").start();
    }
}
