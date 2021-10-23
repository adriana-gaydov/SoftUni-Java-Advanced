package Froggy;
import java.util.Arrays;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String command = sc.nextLine();
        while (!command.equals("END")) {
            Lake lake = new Lake(Arrays.stream(command.split(", ")).mapToInt(Integer::parseInt).toArray());
            print(lake);
            command = sc.nextLine();
        }
    }

    private static void print(Lake lake) {
        StringBuilder sb = new StringBuilder();
        for (Integer integer : lake) {
            sb.append(integer + ", ");
        }
        sb.delete(sb.length() - 2, sb.length());
        System.out.println(sb);
    }
}
