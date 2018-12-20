package the_aop.aop;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = "the.basic.aop.aop")
@EnableAspectJAutoProxy
public class SpringConfig {

}
