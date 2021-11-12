package Vehicles;

public class Truck extends Vehicle {
    private static final double AC_ADDITIONAL_CONSUMPTION = 1.6;
    private static final double REFUEL_PERCENTAGE = 0.95;

    public Truck(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption + AC_ADDITIONAL_CONSUMPTION);
    }

    @Override
    public void refuel(double fuel) {
        super.refuel(fuel * REFUEL_PERCENTAGE);
    }
}
