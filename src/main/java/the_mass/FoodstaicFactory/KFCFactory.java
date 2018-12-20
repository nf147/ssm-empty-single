package the_mass.FoodstaicFactory;

public class KFCFactory extends FastFoodFactory {
    @Override
    public Chip createChips() {
        return new KFCChips();
    }

    @Override
    public Ham createHam() {
        return new KFCHam();
    }
}
