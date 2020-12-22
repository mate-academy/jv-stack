package core.stack;

import java.util.EmptyStackException;

public class MateStack<T> {
    private static final int EMPTY_STACK = 0;
    private int size = 0;
    private Node<T> last;

    public void push(T value) {
        Node<T> newNode = new Node<>(last, value);
        if (newNode.prev == null) {
            last = newNode;
        } else {
            last = newNode;
        }
        size++;
    }

    public T peek() {
        isEmpty();
        return last.item;
    }

    public T pop() {
        isEmpty();
        Node<T> lastNode = last;
        last = last.prev;
        size--;
        return lastNode.item;
    }

    public int size() {
        return size;
    }

    private void isEmpty() {
        if (size == EMPTY_STACK) {
            throw new EmptyStackException();
        }
    }

    private static class Node<T> {
        private final T item;
        private final Node<T> prev;

        private Node(Node<T> prev, T value) {
            this.item = value;
            this.prev = prev;
        }
    }
}

