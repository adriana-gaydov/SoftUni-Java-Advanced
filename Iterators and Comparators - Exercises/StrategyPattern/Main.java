package StrategyPattern;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Set<Person> nameSort = new TreeSet<>(new FirstCmp());
        Set<Person> ageSort = new TreeSet<>(new SecondCmp());

        int n = Integer.parseInt(sc.nextLine());

        while (n-- > 0) {
            String[] input = sc.nextLine().split("\\s+");
            nameSort.add(new Person(input[0], Integer.parseInt(input[1])));
            ageSort.add(new Person(input[0], Integer.parseInt(input[1])));
        }

        nameSort.forEach(System.out::println);
        ageSort.forEach(System.out::println);
    }
}
