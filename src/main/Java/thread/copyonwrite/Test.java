package thread.copyonwrite;

import java.util.Map;

/**
 * Created by zzqno on 2017-5-9.
 */
public class Test {
    public static void main(String[] args) {
        CopyOnWriteMap map = new CopyOnWriteMap();
        map.put("1", "1");
        map.put("2", "2");
        System.out.println(map.get(null));
    }
}
