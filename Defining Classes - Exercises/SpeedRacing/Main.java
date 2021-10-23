package SpeedRacing;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        Map<String, Car> cars = new LinkedHashMap<>();

        while (n-- > 0) {
            String[] inputArgs = sc.nextLine().split("\\s+");
            String model = inputArgs[0];
            double fuelAmount = Double.parseDouble(inputArgs[1]);
            double fuelCostPerKilometer = Double.parseDouble(inputArgs[2]);

            cars.putIfAbsent(model, new Car(model, fuelAmount, fuelCostPerKilometer));
        }

        String command = sc.nextLine();
        while (!command.equals("End")) {
            String[] commandArgs = command.split("\\s+");
            String model = commandArgs[1];
            int amountOfKm = Integer.parseInt(commandArgs[2]);

            if(!cars.get(model).drive(amountOfKm)) {
                System.out.println("Insufficient fuel for the drive");
            }
            command = sc.nextLine();
        }

        cars.values().forEach(System.out::println);
    }
}
