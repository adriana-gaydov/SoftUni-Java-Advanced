package EqualityLogic;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Set<Person> treeSet = new TreeSet<>();
        Set<Person> hashSet = new HashSet<>();

        int n = Integer.parseInt(sc.nextLine());

        while (n-- > 0) {
            String[] input = sc.nextLine().split("\\s+");
            treeSet.add(new Person(input[0], Integer.parseInt(input[1])));
            hashSet.add(new Person(input[0], Integer.parseInt(input[1])));
        }

        System.out.println(treeSet.size());
        System.out.println(hashSet.size());
    }
}
