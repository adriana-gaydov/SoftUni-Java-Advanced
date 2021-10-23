package Exam_20February2021;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MagicBox {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayDeque<Integer> queueFirstBox = Arrays.stream(sc.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Integer> stackSecondBox = new ArrayDeque<>();

        Arrays.stream(sc.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(stackSecondBox::push);

        int value = 0;

        while (!queueFirstBox.isEmpty() && !stackSecondBox.isEmpty()) {
            int sum = queueFirstBox.peek() + stackSecondBox.peek();

            if (sum % 2 == 0) {
                value += sum;
                queueFirstBox.poll();
                stackSecondBox.pop();
            } else {
                int removedItem = stackSecondBox.pop();
                queueFirstBox.offer(removedItem);
            }
        }

        String output = queueFirstBox.isEmpty()
                ? "First magic box is empty."
                : "Second magic box is empty.";
        System.out.println(output);

        output = value >= 90
                ? String.format("Wow, your prey was epic! Value: %s", value)
                : String.format("Poor prey... Value: %s", value);
        System.out.println(output);
    }
}
