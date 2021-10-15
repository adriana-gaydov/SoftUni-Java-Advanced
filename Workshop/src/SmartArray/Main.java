package SmartArray;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SmartArray array = new SmartArray();

        for (int i = 0; i < 32; i++) {
            array.add(i + 1);
        }

        for (int i = 0; i < 24; i++) {
            array.remove(0);
        }

        System.out.println(array.contains(25));
        System.out.println(array.contains(233));
            array.add(3, 4);
            array.remove(0);



    }
}
