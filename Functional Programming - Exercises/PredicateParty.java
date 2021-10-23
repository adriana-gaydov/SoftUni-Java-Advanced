import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PredicateParty {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<String> people = Arrays.stream(sc.nextLine().split("\\s+")).collect(Collectors.toList());

        String command = sc.nextLine();
        while (!command.equals("Party!")) {
            String[] commandArgs = command.split("\\s+");


            if (commandArgs[0].equals("Remove")) {
                switch (commandArgs[1]) {
                    case "StartsWith":
                        char letter = commandArgs[2].charAt(0);
                        people.removeIf(e -> e.charAt(0) == letter);
                        break;
                    case "EndsWith":
                        letter = commandArgs[2].charAt(0);
                        people.removeIf(e -> e.charAt(e.length() - 1) == letter);
                        break;
                    case "Length":
                        int length = Integer.parseInt(commandArgs[2]);
                        people.removeIf(e -> e.length() == length);
                        break;
                }
            } else if (commandArgs[0].equals("Double")) {
                switch (commandArgs[1]) {
                    case "StartsWith":
                        String letter = commandArgs[2];
                        List<String> peopleToAdd = people.stream().filter(e -> e.startsWith(letter)).collect(Collectors.toList());
                        people.addAll(peopleToAdd);
                        break;
                    case "EndsWith":
                        letter = commandArgs[2];
                        peopleToAdd = people.stream().filter(e -> e.endsWith(letter)).collect(Collectors.toList());
                        people.addAll(peopleToAdd);
                        break;
                    case "Length":
                        int length = Integer.parseInt(commandArgs[2]);
                        peopleToAdd = people.stream().filter(e -> e.length() == length).collect(Collectors.toList());
                        people.addAll(peopleToAdd);
                        break;
                }
            }
            command = sc.nextLine();
        }

       if (!people.isEmpty()) {
           Collections.sort(people);
           System.out.printf("%s are going to the party!%n", String.join(", ", people));
       } else {
           System.out.println("Nobody is going to the party!");
       }
    }
}
