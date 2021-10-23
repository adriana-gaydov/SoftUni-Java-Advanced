package CarSalesman;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        Map<String, Engine> engineMap = new LinkedHashMap<>();
        List<Car> cars = new ArrayList<>();

        while (n-- > 0) {
            String[] commandArgs = sc.nextLine().split("\\s+");
            String model = commandArgs[0];
            int power = Integer.parseInt(commandArgs[1]);

            Engine engine;
            if (commandArgs.length == 2) {
                engine = new Engine(model, power);
            } else if (commandArgs.length == 4) {
                int displacement = Integer.parseInt(commandArgs[2]);
                String efficiency = commandArgs[3];
                engine = new Engine(model, power, displacement, efficiency);
            } else {
                try {
                    int displacement = Integer.parseInt(commandArgs[2]);
                    engine = new Engine(model, power, displacement);
                } catch (NumberFormatException e) {
                    String efficiency = commandArgs[2];
                    engine = new Engine(model, power, efficiency);
                }
            }
            engineMap.put(model, engine);
        }

        n = Integer.parseInt(sc.nextLine());
        while (n-- > 0) {
            String[] commandArgs = sc.nextLine().split("\\s+");
            String model = commandArgs[0];
            String engineModel = commandArgs[1];
            Engine engine = engineMap.get(engineModel);

            Car car;
            if (commandArgs.length == 2) {
                car = new Car(model, engine);
            } else if (commandArgs.length == 4) {
                int weight = Integer.parseInt(commandArgs[2]);
                String color = commandArgs[3];
                car = new Car(model, engine, weight, color);
            } else {
                try {
                    int weight = Integer.parseInt(commandArgs[2]);
                    car = new Car(model, engine, weight);
                } catch (NumberFormatException e) {
                    String color = commandArgs[2];
                    car = new Car(model, engine, color);
                }
            }
            cars.add(car);
        }
        cars.forEach(System.out::println);
    }
}
