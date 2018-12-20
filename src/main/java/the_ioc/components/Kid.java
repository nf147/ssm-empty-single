package the_ioc.components;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;

@Component
public class Kid {
    @Value("王 小明")
    private String name;

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException {
//        ApplicationContext context = null;
//        Kid kid = context.getBean(Kid.class);
//        System.out.println(kid.getXing());

        Kid kid = Kid.class.newInstance();
        kid.name = "aa";
        System.out.println(kid.name);

        Kid kid1 = new Kid();
        Field name = kid1.getClass().getDeclaredField("name");
        name.setAccessible(true);
        name.set(kid1, "aaa");
        System.out.println(kid1);

    }

    @Override
    public String toString() {
        return "Kid{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getXing() {
        return name.split(" ")[0];
    }
}
