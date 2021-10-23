package CustomList;

import java.util.*;
import java.util.function.Consumer;

public class CustomList<T extends Comparable<T>> implements Iterable<T> {
    private List<T> elements;

    public CustomList() {
        elements = new ArrayList<>();
    }

    public void add(T element) {
        this.elements.add(element);
    }

    public T remove(int index) {
        return this.elements.remove(index);
    }

    public boolean contains(T element) {
        return this.elements.contains(element);
    }

    public void swap(int firstIndex, int secondIndex) {
        Collections.swap(elements, firstIndex, secondIndex);
    }

    public int countGreaterThan(T element) {
        return (int) this.elements.stream().filter(e -> e.compareTo(element) > 0).count();
    }

    public T getMax() {
        return Collections.max(elements);
    }

    public T getMin() {
        return Collections.min(elements);
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        //this.elements.forEach(e -> output.append(e).append(System.lineSeparator()));
        for(T element : this.elements){
            output.append(element).append(System.lineSeparator());
        }
        return output.toString();
    }

    public T get(int index) {
        return this.elements.get(index);
    }

    public int size() {
        return this.elements.size();
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int index = 0;
            @Override
            public boolean hasNext() {
                return index < elements.size();
            }

            @Override
            public T next() {
                T nextElement = elements.get(index);
                index++;
                return nextElement;
            }
        };
    }
}
