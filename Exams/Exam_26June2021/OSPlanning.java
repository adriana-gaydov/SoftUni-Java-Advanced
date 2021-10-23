package Exam_26June2021;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class OSPlanning {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayDeque<Integer> stackTasks = new ArrayDeque<>();
        Arrays.stream(sc.nextLine().split(", "))
                .map(Integer::parseInt)
                .forEach(stackTasks::push);

        ArrayDeque<Integer> queueThreads = Arrays.stream(sc.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));



        int taskToKill = Integer.parseInt(sc.nextLine());

        //boolean isTaskKilled = false;
        int threadKiller;
        while (true) {
            int threadValue = queueThreads.peek();
            int taskValue = stackTasks.peek();

            if (taskToKill == taskValue) {
                threadKiller = threadValue;
                break;
            }

            queueThreads.poll();
            if (threadValue >= taskValue) {
                stackTasks.pop();
            }

        }
        System.out.printf("Thread with value %d killed task %d%n", threadKiller, taskToKill);
        System.out.println(queueThreads.stream().map(String::valueOf).collect(Collectors.joining(" ")));
    }
}
