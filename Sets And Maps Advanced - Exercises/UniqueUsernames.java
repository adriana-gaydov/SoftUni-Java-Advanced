import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class UniqueUsernames {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Set<String> usernames = new LinkedHashSet<>();
        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            usernames.add(sc.nextLine());
        }
        System.out.println(String.join(System.lineSeparator(), usernames));
    }
}
