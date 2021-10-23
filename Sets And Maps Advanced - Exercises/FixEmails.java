import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FixEmails {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, String> emails = new LinkedHashMap<>();

        String name = sc.nextLine();
        while (!name.equals("stop")) {
            String email = sc.nextLine();
            if(!email.toLowerCase().endsWith("com") &&  !email.toLowerCase().endsWith("us")
            && !email.toLowerCase().endsWith("uk")) {
                emails.put(name, email);
            }
            name = sc.nextLine();
        }
        emails.entrySet().forEach(e -> System.out.printf("%s -> %s%n", e.getKey(), e.getValue()));
    }
}
