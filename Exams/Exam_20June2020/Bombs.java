package Exam_20June2020;

import java.util.*;
import java.util.stream.Collectors;

public class Bombs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Integer> bombPouch = new TreeMap<>();
        bombPouch.put("Datura Bombs", 0);
        bombPouch.put("Cherry Bombs", 0);
        bombPouch.put("Smoke Decoy Bombs", 0);
        boolean hasCollectedAll = false;

        ArrayDeque<Integer> queueBombEffect = Arrays.stream(sc.nextLine().split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Integer> stackBombCasing = new ArrayDeque<>();

        Arrays.stream(sc.nextLine().split(", "))
                .map(Integer::parseInt)
                .forEach(stackBombCasing::push);

        while (!queueBombEffect.isEmpty() && !stackBombCasing.isEmpty()) {
            int bombEffect = queueBombEffect.peek();
            int bombCasing = stackBombCasing.peek();
            int sum = bombCasing + bombEffect;

            stackBombCasing.pop();
            if (sum == 40) {
                bombPouch.put("Datura Bombs", bombPouch.get("Datura Bombs") + 1);
                queueBombEffect.poll();
            } else if (sum == 60) {
                bombPouch.put("Cherry Bombs", bombPouch.get("Cherry Bombs") + 1);
                queueBombEffect.poll();
            } else if (sum == 120) {
                bombPouch.put("Smoke Decoy Bombs", bombPouch.get("Smoke Decoy Bombs") + 1);
                queueBombEffect.poll();
            } else {
                stackBombCasing.push(bombCasing - 5);
            }

            if (bombPouch.values().stream().filter(e -> e >= 3).count() == 3) {
                hasCollectedAll = true;
                break;
            }
        }

        if (hasCollectedAll) {
            System.out.println("Bene! You have successfully filled the bomb pouch!");
        } else {
            System.out.println("You don't have enough materials to fill the bomb pouch.");
        }

        if (queueBombEffect.isEmpty()) {
            System.out.println("Bomb Effects: empty");
        } else {
            String out = queueBombEffect.stream().map(String::valueOf).collect(Collectors.joining(", "));
            System.out.printf("Bomb Effects: %s%n", out);
        }

        if (stackBombCasing.isEmpty()) {
            System.out.println("Bomb Casings: empty");
        } else {
            String out = stackBombCasing.stream().map(String::valueOf).collect(Collectors.joining(", "));
            System.out.printf("Bomb Casings: %s%n", out);
        }

        bombPouch.forEach((key, value) -> System.out.printf("%s: %d%n", key, value));
    }
}
