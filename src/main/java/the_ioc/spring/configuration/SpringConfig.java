package the_ioc.spring.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import the_ioc.spring.BookDAO;
import the_ioc.spring.BookService;
import the_ioc.spring.BookService2Impl;
import the_ioc.spring.BookServiceImpl;

@Configuration
//@ComponentScan(basePackages = "the.basic.ioc.components")
@PropertySource("classpath:application.properties")
@Import(MybatisConfig.class)
public class SpringConfig {
    // <bean id="bs1" class="BookServiceImpl" />
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
