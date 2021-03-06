package the_aop.proxy.p5;

import the_aop.proxy.p3.JdkSingProxyGenerator;

import java.lang.reflect.Proxy;

public class Bank implements Withdrable {
    public static void withdrawWithRecord(float howmuch) {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();

        Withdrable withdrable = (Withdrable) Proxy.newProxyInstance(
                loader, Bank.class.getInterfaces(),
                new JdkRecordProxyGenerator(new Bank())
        );

        Withdrable withdrableCanSing = (Withdrable) Proxy.newProxyInstance(
                loader, Bank.class.getInterfaces(),
                new JdkSingProxyGenerator(withdrable)
        );

        withdrableCanSing.withdraw(howmuch);
    }

    @Override
    public void withdraw(float howmuch) {
        if (howmuch > 1000) {
            System.out.println("您没有那么大的额度，请重试");
        } else if (howmuch < 0) {
            System.out.println("取款必须要大于 0 元");
        } else {
            System.out.println("原先余额 - howmuch");
        }
    }
}
