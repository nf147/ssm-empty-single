package the.aop;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import the.aop.animal.Dog;
import the.aop.zgrmyh.Bank;
import the.aop.zgrmyh.Licaizhongxin;

public class YMain {
    public static void main(String[] args) {
        // 首先，容器要初始化好
        ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("learning/spring/aop.xml");
        // AnnotationConfigApplicationContext ioc = new AnnotationConfigApplicationContext(SpringConfig.class);

        Bank bank = ioc.getBean(Bank.class);
        bank.withdraw(333);

        System.out.println("=================");

        Licaizhongxin licaizhongxin = ioc.getBean(Licaizhongxin.class);
        licaizhongxin.tuixiao();

        System.out.println("==================");

        Dog d = ioc.getBean(Dog.class);
        d.eat();

//        Bank o = (Bank) Enhancer.create(Bank.class, null, new CGGreetingProxyGenerator());
//        o.withdraw(323);
    }
}
