package spring_basic.ioc.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring_basic.ioc.spring.configuration.SpringConfig;

import javax.sql.DataSource;


public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        DataSource bean = context.getBean(DataSource.class);
    }

    public static void zhuliudeJavaStyle() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        context.getBean(BookService.class).sayHello();
    }

    public static void chuantongXMLStyle() {

//        BookServiceImpl bs = new BookServiceImpl();
//        bs.sayHello();

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/learning/spring/my-spring.xml");

        Object bs = context.getBean("bs1");
        ((BookService) bs).sayHello();

//        BookServiceImpl bs = context.getBean(BookServiceImpl.class);
//        bs.sayHello();

//        context.getBean(BookService.class).sayHello();

    }
}
