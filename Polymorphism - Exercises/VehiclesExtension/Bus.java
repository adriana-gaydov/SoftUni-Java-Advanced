package VehiclesExtension;

public class Bus extends Vehicle {
    private boolean isEmpty;
    private static final double AC_ADDITIONAL_CONSUMPTION = 1.4;

    public Bus(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
        this.isEmpty = true;
    }

    public void setEmpty(boolean bool) {
        if (isEmpty == bool) {
            return;
        }

        if (!bool) {
            this.setFuelConsumption(getFuelConsumption() + AC_ADDITIONAL_CONSUMPTION);
        } else {
            this.setFuelConsumption(getFuelConsumption() - AC_ADDITIONAL_CONSUMPTION);
        }

        this.isEmpty = bool;
    }

}
