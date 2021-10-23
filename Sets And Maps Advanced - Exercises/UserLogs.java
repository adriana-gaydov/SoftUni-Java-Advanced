import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class UserLogs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Map<String, Integer>> users = new TreeMap<>();

        String input = sc.nextLine();
        while (!input.equals("end")) {
            //"IP={IP.Address} message={A&sample&message} user={username}"
            String[] inputArgs = input.split("\\s+");
            String ipAddress = inputArgs[0].split("=")[1];
            String message = inputArgs[1].split("=")[1];
            String user = inputArgs[2].split("=")[1];

            users.putIfAbsent(user, new LinkedHashMap<>());
            users.get(user).putIfAbsent(ipAddress, 0);
            users.get(user).put(ipAddress, users.get(user).get(ipAddress) + 1);
            input = sc.nextLine();
        }


        users.entrySet().forEach(e -> {
            System.out.println(e.getKey() + ": ");
            int br = 0;
           for (Map.Entry<String, Integer> m : e.getValue().entrySet()) {
               System.out.printf("%s => %d", m.getKey(), m.getValue());
                   if (++br < e.getValue().size()) {
                       System.out.print(", ");
                   } else {
                       System.out.println(".");
                   }
           }
        });
    }
}
