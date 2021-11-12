package WildFarm;

public class Mouse extends Mammal {

    public Mouse(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
    }

    @Override
    public String makeSound() {
        return "SQUEEEAAAK!";
    }

    @Override
    public void eatFood(Food food) {
        if (food instanceof Vegetable) {
            this.setFoodEaten(food.getQuantity());
        } else {
            throw new IllegalArgumentException("Mice are not eating that type of food!");
        }
    }
}
