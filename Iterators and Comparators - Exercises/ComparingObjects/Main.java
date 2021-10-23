package ComparingObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Person> people = new ArrayList<>();
        int equalPeopleCount = 0;
        int diffPeopleCount = 0;

        String input = sc.nextLine();
        while (!input.equals("END")) {
            String[] inputArgs = input.split("\\s+");
            people.add(new Person(inputArgs[0], Integer.parseInt(inputArgs[1]), inputArgs[2]));
            input = sc.nextLine();
        }

        Person personToCompare = people.get(Integer.parseInt(sc.nextLine()) - 1);
        people.remove(personToCompare);

        for (Person p : people) {
            if (p.compareTo(personToCompare) == 0) {
                equalPeopleCount++;
            } else {
                diffPeopleCount++;
            }
        }

        if (equalPeopleCount == 0) {
            System.out.println("No matches");
        } else {
            System.out.printf("%d %d %d", ++equalPeopleCount, diffPeopleCount, people.size() + 1);
        }
    }
}
