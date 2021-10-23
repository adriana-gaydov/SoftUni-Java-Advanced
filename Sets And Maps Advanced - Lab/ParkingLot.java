import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class ParkingLot {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Set<String> parkingLot = new LinkedHashSet<>();

        String input = sc.nextLine();
        while (!input.equals("END")) {
            String[] commandArgs = input.split(", ");

            if (commandArgs[0].equals("IN")) {
                parkingLot.add(commandArgs[1]);
            } else if (commandArgs[0].equals("OUT")) {
                parkingLot.remove(commandArgs[1]);
            }
            input = sc.nextLine();
        }

        if (parkingLot.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        } else {
            System.out.println(String.join(System.lineSeparator(), parkingLot));
        }
    }
}
