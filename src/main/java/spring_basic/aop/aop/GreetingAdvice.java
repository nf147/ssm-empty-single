package spring_basic.aop.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class GreetingAdvice {

    @Before("execution(float *.*(..))")
    public void greeting(JoinPoint jp) {
        System.out.println("中国人民很行欢迎您 !!!");
    }

    @After("execution(* *.*(..))")
    public void bye() {
        System.out.println("欢迎下次光临。");
    }

    @Around("execution(* *.*(..))")
    public void goujiao(ProceedingJoinPoint jp) {
        // jp.proceed();
        System.out.println("汪汪!");
    }
}
