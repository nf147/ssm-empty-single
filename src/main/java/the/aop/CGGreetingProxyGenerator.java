package the.aop;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CGGreetingProxyGenerator implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
       /* GreetingAop greetingAop = new GreetingAop();
        greetingAop.greeting();*/
        return methodProxy.invokeSuper(o, args);
    }
}
