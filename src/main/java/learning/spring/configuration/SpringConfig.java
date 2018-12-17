package learning.spring.configuration;


import learning.spring.BookDAO;
import learning.spring.BookService;
import learning.spring.BookService2Impl;
import learning.spring.BookServiceImpl;
import org.springframework.context.annotation.*;

@Configuration
//@ComponentScan(basePackages = "learning.components")
@PropertySource("classpath:application.properties")
@Import(MybatisConfig.class)
public class SpringConfig {
    // <bean id="bs1" class="learning.spring.BookServiceImpl" />
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
    public BookDAO bookDAO () {
        return new BookDAO();
    }
}
