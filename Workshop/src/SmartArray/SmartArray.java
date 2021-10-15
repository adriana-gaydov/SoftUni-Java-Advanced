package SmartArray;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Consumer;

public class SmartArray {
    private final int INITIAL_CAPACITY = 8;
    private int[] elements;
    private int size;


    public SmartArray() {
        elements = new int[INITIAL_CAPACITY];
        size = 0;
    }

    public void add (int element) {
        if (size >= elements.length) {
            this.elements = resize();
        }
        elements[size++] = element;
    }

    public void add (int index, int element) {
        checkIndex(index);

        if (size + 1 >= this.elements.length) {
            this.elements = resize();
        }

        for (int i = size; i > index; i++) {
            this.elements[i] = this.elements[i - 1];
        }
        elements[index] = element;
    }

    public int get(int index) {
        checkIndex(index);
        return this.elements[index];
    }

    public int remove(int index) {
        checkIndex(index);
        int removedElement = this.elements[index];

        if (size - 1 - index >= 0) System.arraycopy(this.elements, index + 1, this.elements, index, size - 1 - index);
        this.elements[size - 1] = 0;
        size--;
        this.elements = shrink();
        return removedElement;
    }

    public boolean contains(int element) {
        for (int i = 0; i < size; i++) {
            if (this.elements[i] == element) {
                return true;
            }
        }
        return false;
    }

    public void forEach(Consumer<Integer> consumer) {
        for (int i = 0; i < size; i++) {
            consumer.accept(this.elements[i]);
        }
    }

    private int[] resize() {
        int[] newArr = new int[size * 2];
        System.arraycopy(this.elements, 0, newArr, 0, size);
        return newArr;
    }

    private int[] shrink() {
        if (size < INITIAL_CAPACITY) {
            int[] newArr = new int[INITIAL_CAPACITY];
            System.arraycopy(this.elements, 0, newArr, 0, size);
            return newArr;
        }
        if (size <= elements.length / 4) {
            int[] newArr = new int[elements.length / 2];
            System.arraycopy(this.elements, 0, newArr, 0, size);
            return newArr;
        }
        return this.elements;
    }

    private boolean checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        return true;
    }
}
