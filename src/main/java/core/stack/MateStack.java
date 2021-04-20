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
        if (current == null) {
            throw new EmptyStackException();
        }
        return current.value;
    }

    public T pop() {
        if (current == null) {
            throw new EmptyStackException();
        }
        Node<T> deletedValue = current;
        current = current.prev;
        size--;
        return deletedValue.value;
    }

    public int size() {
        return size;
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
