package StackIterator;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Iterator;

public class Stack<Integer> implements Iterable<Integer> {
    private ArrayDeque<Integer> stack;

    public Stack() {
        this.stack = new ArrayDeque<>();
    }

    public void push(int[] elements) {
        Arrays.stream(elements).boxed().forEach(e -> this.stack.push((Integer) e));
    }

    public void pop() {
        if (this.stack.isEmpty()) {
            System.out.println("No elements");
        } else {
            this.stack.pop();
        }
    }


    @Override
    public Iterator<Integer> iterator() {

        return new Iterator<Integer>() {
            private ArrayDeque<Integer> iterStack = new ArrayDeque<>(stack);

            @Override
            public boolean hasNext() {
                return !iterStack.isEmpty();
            }

            @Override
            public Integer next() {
                return iterStack.pop();
            }
        };
    }
}
