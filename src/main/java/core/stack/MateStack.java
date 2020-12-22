package core.stack;

import java.util.EmptyStackException;

public class MateStack<T> {
    private Node<T> tail = null;
    private int size;

    public void push(T value) {
        Node<T> current = new Node<>(value, tail);
        tail = current; //we can inline but it will be less readable
        size++;
    }

    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return tail.value;
    }

    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        T result = tail.value;
        tail = tail.prev;
        size--;
        return result;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private class Node<T> {
        private final Node<T> prev;
        private final T value;

        public Node(T value, Node<T> prev) {
            this.value = value;
            this.prev = prev;
        }
    }
}
