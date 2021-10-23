package RawData;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        List<Car> cars = new ArrayList<>();

        while (n-- > 0) {
            String[] inputArgs = sc.nextLine().split("\\s+");
            String model = inputArgs[0];
            int engineSpeed = Integer.parseInt(inputArgs[1]);
            int enginePower = Integer.parseInt(inputArgs[2]);
            int cargoWeight = Integer.parseInt(inputArgs[3]);
            String cargoType = inputArgs[4];

            Engine engine = new Engine(engineSpeed, enginePower);
            Cargo cargo = new Cargo(cargoWeight, cargoType);
            Tire[] tires = new Tire[4];
            int br1 = 5;
            int br2 = 6;
            for (int i = 0; i < 4; i++) {
                double tirePressure = Double.parseDouble(inputArgs[br1]);
                int tireAge = Integer.parseInt(inputArgs[br2]);
                br1+=2;
                br2+=2;
                tires[i] = new Tire(tirePressure, tireAge);
            }
            Car car = new Car(model, engine, cargo, tires);
            cars.add(car);
        }

        String command = sc.nextLine();
        cars.stream().filter(getPredicate(command, cars))
                .forEach(c -> System.out.println(c.getModel()));
    }

    private static Predicate<Car> getPredicate(String command, List<Car> cars) {
        if (command.equals("fragile")) {
            return c -> c.getCargo().getType().equals("fragile") && (c.getTires()[0].getPressure() < 1
            || c.getTires()[1].getPressure() < 1 || c.getTires()[2].getPressure() < 1 || c.getTires()[3].getPressure() < 1);
        }
        return c -> c.getCargo().getType().equals("flamable") && c.getEngine().getPower() > 250;
    }
}
