package Exam_19August2020;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FlowerWreaths {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int flowerWreaths = 0;
        int leftOutSum = 0;
        ArrayDeque<Integer> stackLilies = new ArrayDeque<>();
        Arrays.stream(sc.nextLine().split(", "))
                .map(Integer::parseInt)
                .forEach(stackLilies::push);

        ArrayDeque<Integer> queueRoses = Arrays.stream(sc.nextLine().split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        while (!stackLilies.isEmpty() && !queueRoses.isEmpty()) {
            int lilies = stackLilies.peek();
            int roses = queueRoses.peek();

            int sum = roses + lilies;

            if (sum > 15) {
                while (lilies + roses > 15) {
                    lilies -= 2;
                }
                sum = roses + lilies;
            }
            if (sum == 15) {
                flowerWreaths++;
                stackLilies.pop();
                queueRoses.poll();
            }

            if (sum < 15) {
                leftOutSum += sum;
                stackLilies.pop();
                queueRoses.poll();
            }
        }

        flowerWreaths += leftOutSum / 15;

        if (flowerWreaths >= 5) {
            System.out.printf("You made it, you are going to the competition with %d wreaths!", flowerWreaths);
        } else {
            System.out.printf("You didn't make it, you need %d wreaths more!", 5 - flowerWreaths);
        }

    }
}
