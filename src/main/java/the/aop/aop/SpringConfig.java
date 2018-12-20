package the.aop.aop;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = "the.aop.aop")
@EnableAspectJAutoProxy
public class SpringConfig {

}
