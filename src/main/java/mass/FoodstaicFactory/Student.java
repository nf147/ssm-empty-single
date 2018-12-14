package mass.FoodstaicFactory;

public class Student {

    public static void main(String[] args) {
        FastFoodFactory foodFactory = new MacFactory();
        foodFactory.createChips().info();
        foodFactory.createHam().show();
    }

}
