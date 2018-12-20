package the_aop.tx_demo;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = "the.basic.tx_demo")
@EnableAspectJAutoProxy
@EnableTransactionManagement
public class SpringConfig {
    @Bean
    public DataSourceTransactionManager transactionManager() {
        return new DataSourceTransactionManager();
    }
}
