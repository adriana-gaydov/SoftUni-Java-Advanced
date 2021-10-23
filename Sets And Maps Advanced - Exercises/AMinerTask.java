import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class AMinerTask {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Integer> resources = new LinkedHashMap<>();

        String input = sc.nextLine();
        while (!input.equals("stop")) {
            int quantity = Integer.parseInt(sc.nextLine());

            resources.putIfAbsent(input, 0);
            resources.put(input, resources.get(input) + quantity);

            input = sc.nextLine();
        }
        resources.entrySet().forEach(e -> {
            System.out.printf("%s -> %d%n", e.getKey(), e.getValue());
        });
    }
}
