package OpinionPoll;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        List<Person> people = new ArrayList<>();

        while (n-- > 0) {
            String[] inputArgs = sc.nextLine().split("\\s+");
            String name = inputArgs[0];
            int age = Integer.parseInt(inputArgs[1]);

            if (age > 30) {
                people.add(new Person(name, age));
            }
        }
        people.stream().sorted(Comparator.comparing(p -> p.getName()))
                .forEach(System.out::println);
    }
}
