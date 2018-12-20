package the.ioc.spring.configuration;


import the.ioc.spring.BookDAO;
import the.ioc.spring.BookService;
import the.ioc.spring.BookService2Impl;
import the.ioc.spring.BookServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

@Configuration
//@ComponentScan(basePackages = "the.ioc.components")
@PropertySource("classpath:application.properties")
@Import(MybatisConfig.class)
public class SpringConfig {
    // <bean id="bs1" class="the.ioc.spring.BookServiceImpl" />
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
