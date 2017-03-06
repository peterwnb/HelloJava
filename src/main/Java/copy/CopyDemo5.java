package copy;

/**
 * Created by zzqno on 2017-3-6.
 */
public class CopyDemo5 {
    public static void main(String[] args) {
        CopyDemo5 copyDemo5 = new CopyDemo5();
        CopyDemo5 copyDemo = copyDemo5;
        System.out.println(copyDemo == copyDemo5);


    }
}
