package VehiclesExtension;

import java.text.DecimalFormat;

public abstract class Vehicle {
    private double fuelQuantity;
    private double fuelConsumption;
    private double tankCapacity;

    public Vehicle(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumption = fuelConsumption;
        this.tankCapacity = tankCapacity;
    }

    public String drive(double distance) {
        double neededFuel = this.fuelConsumption * distance;

        if (neededFuel > this.fuelQuantity) {
            throw new IllegalArgumentException(String.format("%s needs refueling", this.getClass().getSimpleName()));
        }

        this.setFuelQuantity(this.fuelQuantity - neededFuel);
        return String.format("%s travelled %s km", this.getClass().getSimpleName(),
                new DecimalFormat("##.##").format(distance));
    }

    public void refuel(double fuel) {
        if (fuel <= 0) {
            throw new IllegalArgumentException("Fuel must be a positive number");
        }

        setFuelQuantity(this.fuelQuantity + fuel);
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f", this.getClass().getSimpleName(), this.fuelQuantity);
                //new DecimalFormat("##.##").format(this.fuelQuantity));
    }

    public void setFuelQuantity(double fuelQuantity) {
        checkSetFuelQuantity(fuelQuantity);
    }

    private void checkSetFuelQuantity(double fuelQuantity) {
        if (fuelQuantity <= 0) {
            throw new IllegalArgumentException("Fuel must be a positive number");
        }

        if (fuelQuantity > tankCapacity) {
            throw new IllegalArgumentException("Cannot fit fuel in tank");
        }

        this.fuelQuantity = fuelQuantity;
    }

    protected void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }
}
