package the_aop.proxy.p3;

import the_aop.proxy.p1.Examable;
import the_aop.proxy.p1.Student;
import the_aop.proxy.p2.Girl;
import the_aop.proxy.p2.Sleepable;

import java.lang.reflect.Proxy;

public class Main {
    public static void main(String[] args) {
        ClassLoader cl = Thread.currentThread().getContextClassLoader();

        Examable cheater = (Examable) Proxy.newProxyInstance(
                cl, new Class[]{Examable.class},
                new JdkSingProxyGenerator(new Student())
        );

        cheater.exam();

        System.out.println("-----------------");

        Sleepable sleepable = (Sleepable) Proxy.newProxyInstance(
                cl, Girl.class.getInterfaces(),
                new JdkSingProxyGenerator(new Girl())
        );

        sleepable.sleep();
    }
}
