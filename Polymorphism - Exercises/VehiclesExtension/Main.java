package VehiclesExtension;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static Map<String, Vehicle> vehicles = new LinkedHashMap<>();

    public static void main(String[] args) {

        Vehicle car = createVehicle();
        Vehicle truck = createVehicle();
        Vehicle bus = createVehicle();
        vehicles.put("Car", car);
        vehicles.put("Truck", truck);
        vehicles.put("Bus", bus);

        int n = Integer.parseInt(sc.nextLine());

        while (n-- > 0) {
            String[] tokens = sc.nextLine().split("\\s+");
            String commandType = tokens[0];
            String vehicleType = tokens[1];
            double distanceOrFuel = Double.parseDouble(tokens[2]);

            try {
                switch (commandType) {
                    case "Drive":
                        if (vehicles.get(vehicleType) instanceof Bus) {
                            ((Bus) vehicles.get(vehicleType)).setEmpty(false);
                        }
                        System.out.println(vehicles.get(vehicleType).drive(distanceOrFuel));
                        break;
                    case "DriveEmpty":
                        if (vehicles.get(vehicleType) instanceof Bus) {
                            ((Bus) vehicles.get(vehicleType)).setEmpty(true);
                        }
                        System.out.println(vehicles.get(vehicleType).drive(distanceOrFuel));
                        break;
                    case "Refuel":
                        vehicles.get(vehicleType).refuel(distanceOrFuel);
                        break;
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

        }

        vehicles.values().forEach(System.out::println);

    }

    private static Vehicle createVehicle() {
        String[] tokens = sc.nextLine().split("\\s+");
        String vehicleType = tokens[0];
        double fuelQuantity = Double.parseDouble(tokens[1]);
        double fuelConsumption = Double.parseDouble(tokens[2]);
        double tankCapacity = Double.parseDouble(tokens[3]);

        switch (vehicleType) {
            case "Car":
                return new Car(fuelQuantity, fuelConsumption, tankCapacity);
            case "Truck":
                return new Truck(fuelQuantity, fuelConsumption, tankCapacity);
            case "Bus":
                return new Bus(fuelQuantity, fuelConsumption, tankCapacity);
            default:
                throw new IllegalArgumentException("No such vehicle!");
        }
    }
}
