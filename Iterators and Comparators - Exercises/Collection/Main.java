package Collection;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<String> elementsToAdd = Arrays.stream(sc.nextLine().split("\\s+")).skip(1).collect(Collectors.toList());
        ListyIterator listyIterator = new ListyIterator(elementsToAdd);

        String command = sc.nextLine();
        while (!command.equals("END")) {
            if (command.equals("Move")) {
                System.out.println(listyIterator.move());
            } else if (command.equals("HasNext")) {
                System.out.println(listyIterator.hasNext());
            } else if (command.equals("Print")) {
                try {
                    listyIterator.print();
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            } else if (command.equals("PrintAll")) {
                try {
                    listyIterator.printAll();
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }
            command = sc.nextLine();
        }
    }
}
