import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class PopulationCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Map<String, Long>> population = new LinkedHashMap<>();

        String input = sc.nextLine();
        while (!input.equals("report")) {
            String[] inputArgs = input.split("\\|");
            String city = inputArgs[0];
            String country = inputArgs[1];
            long popul = Integer.parseInt(inputArgs[2]);

            population.putIfAbsent(country, new LinkedHashMap<>());
            population.get(country).put(city, popul);
            input = sc.nextLine();
        }

        population.entrySet().stream().sorted((e1, e2) -> Long.compare(getTotalPopulation(e2.getValue()), getTotalPopulation(e1.getValue())))
            .forEach(e -> {
            System.out.printf("%s (total population: %d)%n", e.getKey(), getTotalPopulation(e.getValue()));
            e.getValue().entrySet().stream().sorted((e1, e2) -> Long.compare(e2.getValue(), e1.getValue()))
                    .forEach(c -> {
                System.out.printf("=>%s: %d%n", c.getKey(), c.getValue());
            });
        });
    }

    private static long getTotalPopulation(Map<String, Long> map) {
        long sum = 0;
        for (Map.Entry<String, Long> e : map.entrySet()) {
            sum += e.getValue();
        }
        return  sum;
    }
}
