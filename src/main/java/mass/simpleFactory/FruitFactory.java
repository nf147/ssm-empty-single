package mass.simpleFactory;

public class FruitFactory {

    public static Fruit getFruit(String fruitsName){
        switch (fruitsName){
            case "Apple":
                return new Apple();
            case "Banana":
                return new Banana();
                default:
                    throw new IllegalArgumentException("暂时没有这个水果:"+fruitsName);
        }
    }

}
