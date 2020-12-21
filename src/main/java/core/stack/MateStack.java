package core.stack;

import java.util.EmptyStackException;

public class MateStack<T> {
    private Node<T> previous;
    private int size;

    public void push(T value) {
        previous = new Node<>(value, previous);
        size++;
    }

    public T peek() {
        checkSize();
        return previous.value;
    }

    public T pop() {
        checkSize();
        T value = previous.value;
        previous = previous.previous;
        size--;
        return value;
    }

    private void checkSize() {
        if (size == 0) {
            throw new EmptyStackException();
        }
    }

    public int size() {
        return size;
    }

    private static class Node<T> {
        private final T value;
        private final Node<T> previous;

        public Node(T value, Node<T> previous) {
            this.value = value;
            this.previous = previous;
        }
    }
}
