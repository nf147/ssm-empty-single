package mass.simpleFactory;

public class Student {
    public static void main(String[] args) {
//        Fruit buy = null;
//        buy = new Banana();
//        buy.buy();
//        buy = new Apple();
//        buy.buy();

//        Fruit fruit = FruitFactory.getFruit("Banana");
//        fruit.buy();

        Fruit fruit = new Banana();
        fruit.buy();

        Apple apple = new Apple();
        apple.buy();

    }
}
