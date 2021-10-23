package Exam_20February2021.dealership;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Dealership {
    private List<Car> data;
    private String name;
    private int capacity;

    public Dealership(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        data = new ArrayList<>();
    }

    public void add(Car car) {
        if (data.size() >= capacity) {
            return;
        }
        data.add(car);
    }

    public boolean buy(String manufacturer, String model) {
        Car carToBuy = getCar(manufacturer, model);
        if (carToBuy == null) {
            return false;
        }
        data.remove(carToBuy);
        return true;
    }

    public Car getLatestCar() {
        return this.data.stream()
                .max(Comparator.comparing(Car::getYear))
                .orElse(null);
    }

    public Car getCar(String manufacturer, String model) {
        return this.data.stream()
                .filter(e -> e.getManufacturer().equals(manufacturer) && e.getModel().equals(model))
                .findFirst()
                .orElse(null);
    }

    public int getCount() {
        return this.data.size();
    }

    public String getStatistics() {
        StringBuilder output = new StringBuilder(String.format("The cars are in a car Exam_20February2021.dealership %s:%n", this.name));
        this.data.forEach(e -> output.append(e).append(System.lineSeparator()));
        return output.toString();
    }
}
