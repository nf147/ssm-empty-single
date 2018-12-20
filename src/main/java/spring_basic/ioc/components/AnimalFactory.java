package spring_basic.ioc.components;

public class AnimalFactory {
    public static Goal xxx() {
        System.out.println("kdsjfksdjf");
        return new Goal();
    }

    public static Donkey yyy() {
        return new Donkey();
    }
}
