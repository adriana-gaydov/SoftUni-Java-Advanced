package WildFarm;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayList<Animal> animals = new ArrayList<>();

        String command = sc.nextLine();
        while (!command.equals("End")) {
            Animal animal = createAnimal(command);
            animals.add(animal);
            Food food = createFood();

            System.out.println(animal.makeSound());

            try {
                animal.eatFood(food);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

            command = sc.nextLine();
        }

        animals.forEach(System.out::println);
    }

    private static Food createFood() {
        String[] tokens = sc.nextLine().split("\\s+");
        String foodType = tokens[0];
        int foodQuantity = Integer.parseInt(tokens[1]);

        switch (foodType) {
            case "Meat":
                return new Meat(foodQuantity);
            case "Vegetable":
                return new Vegetable(foodQuantity);
            default:
                throw new IllegalArgumentException("No such food!");
        }
    }

    private static Animal createAnimal(String command) {
        String[] tokens = command.split("\\s+");
        String animalType = tokens[0];
        String animalName = tokens[1];
        double animalWeight = Double.parseDouble(tokens[2]);
        String animalLivingRegion = tokens[3];

        switch (animalType) {
            case "Mouse":
                return new Mouse(animalName, animalType, animalWeight, animalLivingRegion);
            case "Cat":
                return new Cat(animalName, animalType, animalWeight, animalLivingRegion, tokens[4]);
            case "Tiger":
                return new Tiger(animalName, animalType, animalWeight, animalLivingRegion);
            case "Zebra":
                return new Zebra(animalName, animalType, animalWeight, animalLivingRegion);
            default:
                throw new IllegalArgumentException("No such animal!");
        }
    }
}
