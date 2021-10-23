package Threeuple;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Threeuple> threeuples = new ArrayList<>();

        String[] firstLine = sc.nextLine().split("\\s+");
        String[] secondLine = sc.nextLine().split("\\s+");
        String[] thirdLine = sc.nextLine().split("\\s+");

        Threeuple<String, String, String> firstTuple = new Threeuple<>(firstLine[0] + " " + firstLine[1], firstLine[2], firstLine[3]);
        Threeuple<String, Integer, Boolean> secondTuple = new Threeuple<>(secondLine[0], Integer.parseInt(secondLine[1]), secondLine[2].equals("drunk"));
        Threeuple<String, Double, String> thirdTuple = new Threeuple<>(thirdLine[0], Double.parseDouble(thirdLine[1]), thirdLine[2]);

        threeuples.add(firstTuple);
        threeuples.add(secondTuple);
        threeuples.add(thirdTuple);

        printThreeuples(threeuples);
    }

    private static void printThreeuples(List<Threeuple> threeuples) {
        StringBuilder sb = new StringBuilder();
        for (Threeuple threeuple : threeuples) {
            sb.append(threeuple).append("\n");
        }
        System.out.print(sb.toString());
    }
}
