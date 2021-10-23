package LinkedListTraversal;

public class Node<T extends Comparable<T>> {
    public T value;
    public Node<T> next;
    public Node<T> prev;
    public Node(T value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value + "";
    }
}
