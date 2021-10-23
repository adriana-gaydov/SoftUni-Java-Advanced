import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ThePartyReservationFilterModule {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> people = Arrays.stream(sc.nextLine().split("\\s+")).collect(Collectors.toList());
        Map<String, Predicate<String>> predicateMap = new HashMap<>();

        String command = sc.nextLine();
        while (!command.equals("Print")) {
            String[] commandArgs = command.split(";");
            String name = commandArgs[1].split("\\s+")[0] + commandArgs[2];

            Predicate<String> predicate = getPredicate(commandArgs[1], commandArgs[2]);

            if (command.contains("Add")) {
                predicateMap.putIfAbsent(name, predicate);
            } else if (command.contains("Remove")) {
                predicateMap.remove(name);
            }
            command = sc.nextLine();
        }
        for (Map.Entry<String, Predicate<String>> entry : predicateMap.entrySet()) {
            people.removeIf(entry.getValue());
        }

        System.out.println(String.join(" ", people));
    }

    public static Predicate<String> getPredicate (String action, String parameter) {
        switch (action) {
            case "Starts with":
                return e -> e.startsWith(parameter);
            case "Ends with":
                return e -> e.endsWith(parameter);
            case "Length":
                return e -> e.length() == Integer.parseInt(parameter);
            case "Contains":
                return e -> e.contains(parameter);
        }
        return null;
    }
}
