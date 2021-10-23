package GenericArrayCreator;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Integer[] arr = ArrayCreator.create(Integer.class, 2, 2);
        Arrays.stream(arr).forEach(System.out::println);
    }
}
