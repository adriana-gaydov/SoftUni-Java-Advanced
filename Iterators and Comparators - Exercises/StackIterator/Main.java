package StackIterator;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> stack = new Stack();

        String command = sc.nextLine();
        while (!command.equals("END")) {

            if (command.contains("Push")) {
                String toPush = command.substring(5).trim();
                stack.push(Arrays.stream(toPush.split(", ")).mapToInt(Integer::parseInt).toArray());
            } else if (command.contains("Pop")) {
                stack.pop();
            }
            command = sc.nextLine();
        }

        stack.forEach(System.out::println);
        stack.forEach(System.out::println);
    }
}
