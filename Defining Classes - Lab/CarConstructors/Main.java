package CarConstructors;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<Car> cars = new ArrayList<>();

        Car car;
        while (n-- > 0) {
            String[] inputArgs = sc.nextLine().split("\\s+");

            if (inputArgs.length == 1) {
                car = new Car(inputArgs[0]);
            } else {
                car = new Car(inputArgs[0], inputArgs[1], Integer.parseInt(inputArgs[2]));
            }
            cars.add(car);
        }
        cars.forEach(System.out::println);
    }
}
