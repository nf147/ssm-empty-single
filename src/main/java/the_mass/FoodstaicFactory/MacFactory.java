package the_mass.FoodstaicFactory;

public class MacFactory extends FastFoodFactory {
    @Override
    public Chip createChips() {
        return new MacChips();
    }

    @Override
    public Ham createHam() {
        return new MacHam();
    }
}
