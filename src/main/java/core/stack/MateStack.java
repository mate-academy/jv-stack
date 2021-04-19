package core.stack;

import java.util.EmptyStackException;

public class MateStack<T> {
    private int size;
    private Node<T> current;

    private static class Node<T> {
        private final T value;
        private Node<T> prev;

        private Node(Node<T> prev, T value) {
            this.value = value;
            this.prev = prev;
        }
    }

    public void push(T value) {
        Node<T> nextNode = new Node<>(null, value);
        if (size != 0) {
            nextNode.prev = current;
        }
        current = nextNode;
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
        final Node<T> temp = current;
        current = current.prev;
        size--;
        return temp.value;
    }

    public int size() {
        return size;
    }
}
