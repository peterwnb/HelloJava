package rpc.proxy;

/**
 * Created by monster_zzq on 2016/9/6.
 */
public class HelloWorldServiceImpl implements HelloWorldService {

    public String sayHello(String msg) {
        String result = "hello world " + msg;
        System.out.println(result);
        return result;
    }
}
