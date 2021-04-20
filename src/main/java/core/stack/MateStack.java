package core.stack;

import java.util.EmptyStackException;

public class MateStack<T> {
    private int size;
    private Node<T> node;

    private static class Node<T> {
        private final T value;
        private Node<T> prev;

        private Node(Node<T> prev, T value) {
            this.value = value;
            this.prev = prev;
        }
    }

    public void push(T value) {
        size++;
        node = new Node<>(node, value);
    }

    public T peek() {
        if (node == null) {
            throw new EmptyStackException();
        }
        return node.value;
    }

    public T pop() {
        if (node == null) {
            throw new EmptyStackException();
        }
        Node<T> temp = node;
        node = node.prev;
        size--;
        return temp.value;
    }

    public int size() {
        return size;
    }
}
