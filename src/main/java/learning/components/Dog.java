package learning.components;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Dog {

    @Value("旺财 #{'Hello World'.substring(3)}")
    private String name;

    @Value("#{'Hello World'.length}")
    private int lengthOfName;

    @Value("#{ java.lang.Math.random() * 10000 }")
    //@Value("#{ T(java.lang.Math).random() * 10000.0 }")
    private float salary;

    @Autowired
    private Leg leg;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
