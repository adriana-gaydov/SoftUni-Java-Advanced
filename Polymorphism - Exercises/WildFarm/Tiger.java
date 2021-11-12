package WildFarm;

public class Tiger extends Felime {

    public Tiger(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
    }

    @Override
    public String makeSound() {
        return "ROAAR!!!";
    }

    @Override
    public void eatFood(Food food) {
        if (food instanceof Meat) {
            this.setFoodEaten(food.getQuantity());
        } else {
            throw new IllegalArgumentException("Tigers are not eating that type of food!");
        }
    }
}
