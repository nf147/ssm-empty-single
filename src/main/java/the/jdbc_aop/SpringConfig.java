package the.jdbc_aop;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = "the.jdbc_aop")
@EnableAspectJAutoProxy
public class SpringConfig {

}
