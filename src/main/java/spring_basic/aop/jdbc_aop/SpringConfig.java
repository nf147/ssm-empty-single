package spring_basic.aop.jdbc_aop;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = "spring_basic.aop.jdbc_aop")
@EnableAspectJAutoProxy
public class SpringConfig {

}
