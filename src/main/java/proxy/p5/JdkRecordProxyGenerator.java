package proxy.p5;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class JdkRecordProxyGenerator implements InvocationHandler {

    private Object object;

    public JdkRecordProxyGenerator(Object o) {
        this.object = o;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws InvocationTargetException, IllegalAccessException {
        System.out.println("xx 在 yy 时间，作了 xxx 操作");
        System.out.println("这里应该有若干逻辑，若干代码");
        System.out.println("执行完之后，才能继续。。。。");

        return method.invoke(object, args);
    }
}
