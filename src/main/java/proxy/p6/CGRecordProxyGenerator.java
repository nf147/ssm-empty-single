package proxy.p6;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CGRecordProxyGenerator implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("将整个操作记录到数据库");

        Object res = methodProxy.invokeSuper(o, args);

        System.out.println("结果是: " + res);

        return res;
    }
}
