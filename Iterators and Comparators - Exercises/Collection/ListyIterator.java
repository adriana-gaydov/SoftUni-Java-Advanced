package Collection;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ListyIterator implements Iterable<String> {
    private List<String> data;
    private int index;

    public ListyIterator(List<String> elements) {
        this.data = elements;
        index = 0;
    }

    public boolean move() {
        if (hasNext()) {
            index++;
            return true;
        }
        return false;
    }

    public void print() {
        if (this.data.isEmpty()) {
            throw new IllegalArgumentException("Invalid Operation!");
        }
        System.out.println(data.get(index));
    }

    public void printAll() {
        if (this.data.isEmpty()) {
            throw new IllegalArgumentException("Invalid Operation!");
        }
        this.data.forEach(e -> System.out.print(e + " "));
        System.out.println();
    }

    public boolean hasNext() {
        return index < data.size() - 1;
    }


    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < data.size();
            }

            @Override
            public String next() {
                String currentElement = data.get(index);
                index++;
                return currentElement;
            }
        };
    }
}
