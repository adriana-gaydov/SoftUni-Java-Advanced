package VehiclesExtension;

public class Truck extends Vehicle {
    private static final double AC_ADDITIONAL_CONSUMPTION = 1.6;
    private static final double REFUEL_PERCENTAGE = 0.95;

    public Truck(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption + AC_ADDITIONAL_CONSUMPTION, tankCapacity);
    }

    @Override
    public void refuel(double fuel) {
        super.refuel(fuel * REFUEL_PERCENTAGE);
    }
}
