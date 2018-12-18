package proxy.p4;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class JdkDemoProxyGenerator implements InvocationHandler {

    private Object object;

    public JdkDemoProxyGenerator(Object o) {
        this.object = o;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args)  {
        // 前置通知 (before advice)
        System.out.println("目前执行的方法是：" + method.getName());

        try {
            // 1
            long startTime = System.currentTimeMillis();

            Object result = method.invoke(object, args);

            // 2
            // 环绕通知 (Around Advice)
            System.out.println("运行时间：" + (System.currentTimeMillis() - startTime)  + "毫秒");

            // 返回前通知 (Before Returning Advice)，能够使用到 result 作为参数
            System.out.println("函数的运行结果为: " + result);

            return result;
        } catch (Exception e) {
            // 异常通知 (After Throwing)
            System.out.println("运行出错！");
        } finally {
            // 最终通知 (After Advice)
            System.out.println("再见");
        }
        return null;
    }
}
