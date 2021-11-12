package Vehicles;

import java.text.DecimalFormat;

public abstract class Vehicle {
    private double fuelQuantity;
    private double fuelConsumption;

    public Vehicle(double fuelQuantity, double fuelConsumption) {
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumption = fuelConsumption;
    }

    public String drive(double distance) {
        double neededFuel = this.fuelConsumption * distance;

        if (neededFuel > this.fuelQuantity) {
            throw new IllegalArgumentException(String.format("%s needs refueling", this.getClass().getSimpleName()));
        }

        this.fuelQuantity -= neededFuel;
        return String.format("%s travelled %s km", this.getClass().getSimpleName(),
                new DecimalFormat("##.##").format(distance));
    }

    public void refuel(double fuel) {
        this.fuelQuantity += fuel;
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f", this.getClass().getSimpleName(), this.fuelQuantity);
                //new DecimalFormat("##.##").format(this.fuelQuantity));
    }
}
