package Vehicles;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static Map<String, Vehicle> vehicles = new LinkedHashMap<>();

    public static void main(String[] args) {

        Vehicle car = createVehicle();
        Vehicle truck = createVehicle();
        vehicles.put("Car", car);
        vehicles.put("Truck", truck);

        int n = Integer.parseInt(sc.nextLine());

        while (n-- > 0) {
            String[] tokens = sc.nextLine().split("\\s+");
            String commandType = tokens[0];
            String vehicleType = tokens[1];
            double distanceOrFuel = Double.parseDouble(tokens[2]);

            switch (commandType) {
                case "Drive":
                    try {
                        System.out.println(vehicles.get(vehicleType).drive(distanceOrFuel));
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "Refuel":
                    vehicles.get(vehicleType).refuel(distanceOrFuel);
                    break;
            }
        }

        vehicles.values().forEach(System.out::println);

    }

    private static Vehicle createVehicle() {
        String[] tokens = sc.nextLine().split("\\s+");
        String vehicleType = tokens[0];
        double fuelQuantity = Double.parseDouble(tokens[1]);
        double fuelConsumption = Double.parseDouble(tokens[2]);

        switch (vehicleType) {
            case "Car":
                return new Car(fuelQuantity, fuelConsumption);
            case "Truck":
                return new Truck(fuelQuantity, fuelConsumption);
            default:
                throw new IllegalArgumentException("No such vehicle!");
        }
    }
}
