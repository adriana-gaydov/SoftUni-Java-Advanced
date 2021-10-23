package GenericBox;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends  Comparable<T>> {
    private List<T> data;

    public Box() {
        data = new ArrayList<>();
    }

    public void add(T value) {
        this.data.add(value);
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public int getCountOfGreaterElements(T value) {
        return (int) this.data.stream().filter(e -> e.compareTo(value) > 0).count();
    }

    public void swap(int firstIndex, int secondIndex) {
        T temp = this.data.get(firstIndex);
        this.data.set(firstIndex, this.data.get(secondIndex));
        this.data.set(secondIndex, temp);
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        this.data.forEach(e -> output.append(String.format("%s: %s%n", e.getClass().getName(), e)));
        return output.toString();
    }
}
