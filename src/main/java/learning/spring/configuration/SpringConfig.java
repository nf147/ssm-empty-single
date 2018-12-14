package learning.spring.configuration;


import learning.spring.BookDAO;
import learning.spring.BookService;
import learning.spring.BookService2Impl;
import learning.spring.BookServiceImpl;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan(basePackages = "learning.components")
@Import({ShiroConfig.class, MybatisConfig.class, ScheduleConfig.class})
public class SpringConfig {
    // <bean id="bs1" class="learning.spring.BookServiceImpl" />
    @Bean
    public BookService bs1() {
        System.out.println(bookDAO());
        if (Math.random() > 0.5) {
            return new BookService2Impl();
        } else {
            return new BookServiceImpl();
        }
    }

    @Bean
    public BookDAO bookDAO () {
        return new BookDAO();
    }
}
