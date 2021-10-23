package Google;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Person> people = new LinkedHashMap<>();

        String input = sc.nextLine();
        while (!input.equals("End")) {
            String[] inputArgs = input.split("\\s+");
            String name = inputArgs[0];

            Person person;
            if (people.containsKey(name)) {
                person = people.get(name);
            } else {
                person = new Person(name);
            }
            switch (inputArgs[1]) {
                case "company":
                    String companyName = inputArgs[2];
                    String department = inputArgs[3];
                    double salary = Double.parseDouble(inputArgs[4]);
                    person.setCompany(new Company(companyName, department, salary));
                    break;
                case "pokemon":
                    String pokemonName = inputArgs[2];
                    String pokemonType = inputArgs[3];
                    person.getPokemons().add(new Pokemon(pokemonName, pokemonType));
                    break;
                case "parents":
                    String parentName = inputArgs[2];
                    String parentBirthday = inputArgs[3];
                    person.getParents().add(new Parent(parentName, parentBirthday));
                    break;
                case "children":
                    String childName = inputArgs[2];
                    String childBirthday = inputArgs[3];
                    person.getChildren().add(new Child(childName, childBirthday));
                    break;
                case "car":
                    String carModel = inputArgs[2];
                    int carSpeed = Integer.parseInt(inputArgs[3]);
                    person.setCar(new Car(carModel, carSpeed));
                    break;
            }
            people.put(name, person);
            input = sc.nextLine();
        }
        printPeople(people, sc.nextLine());
    }
    public static void printPeople(Map<String, Person> people, String name) {
             Person p = people.get(name);
            System.out.println(p.getName());
            System.out.println("Company:");
            if (p.getCompany() != null) {
                System.out.println(p.getCompany());
            }
            System.out.println("Car:");
            if (p.getCar() != null) {
                System.out.println(p.getCar());
            }
            System.out.println("Pokemon:");
            if (!p.getPokemons().isEmpty()) {
                p.getPokemons().forEach(System.out::println);
            }
            System.out.println("Parents:");
            if (!p.getParents().isEmpty()) {
                p.getParents().forEach(System.out::println);
            }
            System.out.println("Children:");
            if (!p.getChildren().isEmpty()) {
                p.getChildren().forEach(System.out::println);
            }
    }
}
