import java.util.*;

public class CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        Map<String, Map<String, List<String>>> map = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String[] inputArgs = sc.nextLine().split("\\s+");
            String continent = inputArgs[0];
            String country = inputArgs[1];
            String city = inputArgs[2];

            Map<String, List<String>> m;
            if (!map.containsKey(continent)) {
                m = new LinkedHashMap<>();
                m.put(country, new ArrayList<>());
            } else {
                m = map.get(continent);
                m.putIfAbsent(country, new ArrayList<>());
            }
            m.get(country).add(city);
            map.put(continent, m);
        }
        map.entrySet().forEach(e -> {
            System.out.println(e.getKey() + ":");
            e.getValue().entrySet().forEach(c -> {
                System.out.printf("  %s -> %s%n", c.getKey(), String.join(", ", c.getValue()));
            });
        });
    }
}
