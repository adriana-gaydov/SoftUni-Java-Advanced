import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Phonebook {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, String> phonebook = new LinkedHashMap<>();

        String input = sc.nextLine();
        while (!input.equals("search")) {
            String[] inputArgs = input.split("-");
            phonebook.put(inputArgs[0], inputArgs[1]);
            input = sc.nextLine();
        }

        input = sc.nextLine();
        while (!input.equals("stop")) {
            if (!phonebook.containsKey(input)) {
                System.out.printf("Contact %s does not exist.%n", input);
            } else {
                System.out.printf("%s -> %s%n", input, phonebook.get(input));
            }
            input = sc.nextLine();
        }
    }
}
