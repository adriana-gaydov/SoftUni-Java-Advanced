package GenericBox;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Box<Double> box = new Box<>();

        int n = Integer.parseInt(sc.nextLine());
        while (n-- > 0) {
            box.add(Double.parseDouble(sc.nextLine()));
        }

        Double input = Double.parseDouble(sc.nextLine());
        System.out.println(box.getCountOfGreaterElements(input));
    }
}
