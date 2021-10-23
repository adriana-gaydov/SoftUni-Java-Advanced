import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateParty2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<String> people = Arrays.stream(sc.nextLine().split("\\s+")).collect(Collectors.toList());

        String command = sc.nextLine();
        while (!command.equals("Party!")) {
            String[] commandArgs = command.split("\\s+");

            String criteria = commandArgs[2];
            Predicate<String> predicate = null;
            if (commandArgs[1].equals("Length")) {
                predicate = e -> e.length() == Integer.parseInt(criteria);
            } else if (commandArgs[1].equals("StartsWith")) {
                predicate = e -> e.startsWith(criteria);
            } else if (commandArgs[1].equals("EndsWith")) {
                predicate = e -> e.endsWith(criteria);
            }

            if (commandArgs[0].equals("Remove")) {
                people.removeIf(predicate);
            } else if (commandArgs[0].equals("Double")) {
                List<String> peopleToAdd = new ArrayList<>();
                peopleToAdd = people.stream().filter(predicate).collect(Collectors.toList());
                people.addAll(peopleToAdd);
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
