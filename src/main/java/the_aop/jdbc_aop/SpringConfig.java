package the_aop.jdbc_aop;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = "the.basic.aop.jdbc_aop")
@EnableAspectJAutoProxy
public class SpringConfig {

}
