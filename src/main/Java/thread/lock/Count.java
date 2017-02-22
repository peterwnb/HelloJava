package thread.lock;

/**
 * Created by zzq on 16-10-26.
 */
public class Count {
    public int num;

    public  synchronized void add(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        num+=1;
        System.out.println(Thread.currentThread().getName()+"-"+num);
    }

}
