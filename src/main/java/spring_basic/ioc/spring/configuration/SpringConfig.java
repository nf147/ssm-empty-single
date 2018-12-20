package spring_basic.ioc.spring.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import spring_basic.ioc.spring.BookDAO;
import spring_basic.ioc.spring.BookService;
import spring_basic.ioc.spring.BookService2Impl;
import spring_basic.ioc.spring.BookServiceImpl;

@Configuration
//@ComponentScan(basePackages = "spring_basic.ioc.components")
@PropertySource("classpath:application.properties")
@Import(MybatisConfig.class)
public class SpringConfig {
    // <bean id="bs1" class="spring_basic.ioc.spring.BookServiceImpl" />
    @Bean(name = "bs110")
    public BookService bs1() {
        System.out.println(bookDAO());
        if (Math.random() > 0.5) {
            return new BookService2Impl();
        } else {
            return new BookServiceImpl();
        }
    }

    @Bean
    public BookDAO bookDAO() {
        return new BookDAO();
    }
}
