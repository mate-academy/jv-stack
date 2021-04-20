package core.stack;

import java.util.EmptyStackException;

public class MateStack<T> {
    private Node<T> tail;
    private int size;

    public void push(T value) {
        tail = new Node<>(value, tail);
        size++;
    }

    public T peek() {
        checkSize();
        return tail.item;
    }

    public T pop() {
        checkSize();
        Node<T> node = tail;
        tail = node.prev;
        size--;
        return node.item;
    }

    public int size() {
        return size;
    }

    private void checkSize() {
        if (size == 0) {
            throw new EmptyStackException();
        }
    }

    private static class Node<T> {
        private final T item;
        private final Node<T> prev;

        private Node(T value, Node<T> prev) {
            this.item = value;
            this.prev = prev;
        }
    }
}
