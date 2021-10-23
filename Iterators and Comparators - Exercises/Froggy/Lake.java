package Froggy;

import java.util.Iterator;
import java.util.function.Consumer;

public class Lake implements Iterable<Integer>{
    private int[] numbers;

    public Lake(int[] numbers) {
        this.numbers = numbers;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            private int index = 0;
            private boolean isFirstRound = true;
            @Override
            public boolean hasNext() {
                return index < numbers.length;
            }

            @Override
            public Integer next() {
                Integer current = numbers[index];
                if ((index == numbers.length - 2 || index == numbers.length - 1) && isFirstRound) {
                    index = 1;
                    isFirstRound = false;
                } else {
                    index +=2;
                }
                return current;
            }
        };
    }

    @Override
    public void forEach(Consumer<? super Integer> p) {
        for (Integer i : this) {
            p.accept(i);
        }
    }
}
