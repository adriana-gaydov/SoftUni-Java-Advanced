import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class SoftUniParty {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Set<String> guests = new TreeSet<>();

        String guest = sc.nextLine();
        while (!guest.equals("PARTY")) {
            guests.add(guest);
            guest = sc.nextLine();
        }

        guest = sc.nextLine();
        while (!guest.equals("END")) {
            guests.remove(guest);
            guest = sc.nextLine();
        }
        System.out.println(guests.size());
        System.out.println(String.join(System.lineSeparator(), guests));
    }
}
