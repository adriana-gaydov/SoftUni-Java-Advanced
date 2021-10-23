package CustomList;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        CustomList<String> customList = new CustomList<String>();
        String command = sc.nextLine();

        while (!command.equals("END")) {
            String[] commandArgs = command.split("\\s+");
            switch (commandArgs[0]) {
                case "Add":
                    String element = commandArgs[1];
                    customList.add(element);
                    break;
                case "Remove":
                    int index = Integer.parseInt(commandArgs[1]);
                    customList.remove(index);
                    break;
                case "Contains":
                    element = commandArgs[1];
                    System.out.println(customList.contains(element));
                    break;
                case "Swap":
                    int firstIndex = Integer.parseInt(commandArgs[1]);
                    int secondIndex = Integer.parseInt(commandArgs[2]);
                    customList.swap(firstIndex, secondIndex);
                    break;
                case "Greater":
                    element = commandArgs[1];
                    System.out.println(customList.countGreaterThan(element));
                    break;
                case "Max":
                    System.out.println(customList.getMax());
                    break;
                case "Min":
                    System.out.println(customList.getMin());
                    break;
                case "Print":
                    System.out.print(customList);
                    break;
                case "Sort":
                    Sorter.sort(customList);
            }
            command = sc.nextLine();
        }
    }
}
