import java.util.*;
import java.util.stream.Collectors;

public class LogsAggregator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Map<String, Integer>> logs = new TreeMap<>();
        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            String[] inputArgs = sc.nextLine().split("\\s+");
            String ipAddress = inputArgs[0];
            String user = inputArgs[1];
            int duration = Integer.parseInt(inputArgs[2]);

            logs.putIfAbsent(user, new TreeMap<>());
            logs.get(user).putIfAbsent(ipAddress, 0);
            logs.get(user).put(ipAddress, logs.get(user).get(ipAddress) + duration);

        }

        logs.entrySet().forEach(e -> {
            List<String> ips = new ArrayList<>(e.getValue().keySet());
            int totalDuration = getTotalDuration(e.getValue());
            System.out.printf("%s: %d %s%n", e.getKey(), totalDuration, ips);
            });
        }

    private static int getTotalDuration(Map<String, Integer> value) {
        return value.values().stream().mapToInt(e -> e).sum();
    }
}

