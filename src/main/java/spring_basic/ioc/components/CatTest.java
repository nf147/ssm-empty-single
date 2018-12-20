package spring_basic.ioc.components;

public class CatTest {

    public static void main(String[] args) {
        Cat cat = new Cat();
        cat.setImage(new Image());
    }
}
