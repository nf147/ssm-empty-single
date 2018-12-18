package the.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class GreetingAdvice {

    @Before("execution(float *.*(..))")
    public void greeting() {
        System.out.println("中国人民很行欢迎您 !!!");
    }

    @After("execution(* *.*(..))")
    public void bye () {
        System.out.println("欢迎下次光临。");
    }

    public void goujiao () {
        System.out.println("汪汪!");
    }

}
