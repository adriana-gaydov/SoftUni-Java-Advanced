package SpeedRacing;

public class Car {
    private String model;
    private double fuelAmount;
    private double fuelCostPerKilometer;
    private int distanceTravelled;

    public Car(String model, double fuelAmount, double fuelCostPerKilometer) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelCostPerKilometer = fuelCostPerKilometer;
        this.distanceTravelled = 0;
    }

    public boolean drive(int amountOfKm) {
        double neededFuel = amountOfKm * fuelCostPerKilometer;

        if (neededFuel > fuelAmount) {
            return false;
        }

        distanceTravelled += amountOfKm;
        fuelAmount -= neededFuel;
        return true;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %d", model, fuelAmount, distanceTravelled);
    }
}
