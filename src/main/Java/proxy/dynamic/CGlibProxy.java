package proxy.dynamic;

import ioc.User;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by zzqno on 2017-3-27.
 */
public class CGlibProxy implements MethodInterceptor {

    public <T> T getProxy(Class<T> cls) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(cls);
        // 回调方法
        enhancer.setCallback(this);
        // 创建代理对象
        return (T) enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        before();
        methodProxy.invokeSuper(o, objects);
        after();
        return null;
    }

    private void before() {
        System.out.println("before");
    }

    private void after() {
        System.out.println("after");
    }

    public static void main(String[] args) {
        CGlibProxy proxy = new CGlibProxy();
        User user = proxy.getProxy(User.class);
        user.getUserID();
    }
}
