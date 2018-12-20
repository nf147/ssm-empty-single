package the_aop.proxy.p6;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CGGreetingProxyGenerator implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println(">> 您好，欢迎光临中国银行。");
        return methodProxy.invokeSuper(o, args);
    }
}
