package WildFarm;

import java.text.DecimalFormat;

public abstract class Mammal extends Animal {
    private String livingRegion;

    public Mammal(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight);
        this.livingRegion = livingRegion;
    }

    @Override
    public String toString() {
        return String.format("%s[%s, %s, %s, %d]", getAnimalType(), getAnimalName(),
                new DecimalFormat("##.##").format(getAnimalWeight()), this.livingRegion, getFoodEaten());
    }

    public String getLivingRegion() {
        return livingRegion;
    }
}
