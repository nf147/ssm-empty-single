package spring_basic.aop.aop.animal;

import org.springframework.stereotype.Component;

@Component
public class Dog {
    public void eat() {
        System.out.println("很香！");
    }
}
