package LinkedListTraversal;

import java.util.Iterator;

public class DoublyLinkedList<T extends Comparable<T>> implements Iterable<Node> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public void add(T item) {
        if (size == 0) {
            head = tail = new Node<T>(item);
        } else {
            Node<T> oldTail = this.tail;
            oldTail.next = this.tail = new Node<T>(item);
        }

        size++;
    }

    public void remove(T item) {
        if (this.size == 0) {
            return;
        }

        if (this.head.value.compareTo(item) == 0) {
            this.head = this.head.next;
            size--;
            return;
        }

        Node<T> previous = this.head;
        Node<T> current = this.head.next;

        while (current != null) {
            if (current.value.compareTo(item) == 0) {
                previous.next = current.next;
                size--;
                return;
            }

            previous = current;
            current = current.next;
        }
    }

    public int size() {
        return size;
    }

    public Iterator<Node> iterator() {
        return new Iterator<>() {
            private Node currentNode = head;

            @Override
            public boolean hasNext() {
                return currentNode != null;
            }

            @Override
            public Node next() {
                Node element = currentNode;
                currentNode = currentNode.next;
                return element;
            }
        };
    }
}