package core.stack;

import java.util.EmptyStackException;

public class MateStack<T> {
    private int size;
    private Node<T> current;

    public void push(T value) {
        current = new Node<>(current, value);
        size++;
    }

    public T peek() {
        checkForNull();
        return current.value;
    }

    public T pop() {
        checkForNull();
        Node<T> deletedValue = current;
        current = current.prev;
        size--;
        return deletedValue.value;
    }

    public int size() {
        return size;
    }

    private void checkForNull() {
        if (current == null) {
            throw new EmptyStackException();
        }
    }

    private static class Node<T> {
        private T value;
        private Node<T> prev;

        private Node(Node<T> prev, T value) {
            this.prev = prev;
            this.value = value;
        }
    }
}
