package the_aop.aop;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import the_aop.aop.animal.Dog;
import the_aop.aop.zgrmyh.Bank;
import the_aop.aop.zgrmyh.Licaizhongxin;

public class YMain {
    public static void main(String[] args) {
        // 首先，容器要初始化好
        ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("learning/spring/the.basic.aop.xml");
        // AnnotationConfigApplicationContext the.basic.ioc = new AnnotationConfigApplicationContext(SpringConfig.class);

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
