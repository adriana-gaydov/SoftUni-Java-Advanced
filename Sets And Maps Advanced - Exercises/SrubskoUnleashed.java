import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SrubskoUnleashed {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String pattern = "(?<singer>[A-Za-z]+[A-Za-z ]*[a-zA-Z]) @(?<venue>[A-Za-z]+[A-Za-z ]*[a-zA-Z]) (?<ticketPrice>\\d+) (?<ticketsCount>\\d+)";
        Matcher m;
        Map<String, Map<String, Integer>> statistics = new LinkedHashMap<>();
        String input = sc.nextLine();
        while (!input.equals("End")) {
            m = Pattern.compile(pattern).matcher(input);
            if (m.find()) {
                String singer = m.group("singer");
                String venue = m.group("venue");
                int ticketPrice = Integer.parseInt(m.group("ticketPrice"));
                int ticketsCount = Integer.parseInt(m.group("ticketsCount"));

                statistics.putIfAbsent(venue, new LinkedHashMap<>());
                statistics.get(venue).putIfAbsent(singer, 0);
                statistics.get(venue).put(singer, statistics.get(venue).get(singer) + ticketsCount * ticketPrice);
            }
            input = sc.nextLine();
        }
        statistics.entrySet().forEach(e -> {
            System.out.println(e.getKey());
            e.getValue().entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                    .forEach(c -> {
                        System.out.printf("#  %s -> %d%n", c.getKey(), c.getValue());
                    });
        });
    }
}
