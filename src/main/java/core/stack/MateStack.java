package core.stack;

import java.util.EmptyStackException;

public class MateStack<T> {
    private int size = 0;
    private Node<T> tail;

    public void push(T value) {
        tail = new Node<>(tail, value);
        size++;
    }

    public T peek() throws EmptyStackException {
        if (size == 0) {
            throw new EmptyStackException();
        }
        return tail.item;
    }

    public T pop() throws EmptyStackException {
        if (size == 0) {
            throw new EmptyStackException();
        }
        T deletedItem = tail.item;
        tail = tail.prev;
        size--;
        return deletedItem;
    }

    public int size() {
        return size;
    }

    private static class Node<T> {
        private final T item;
        private final Node<T> prev;

        Node(Node<T> prev, T element) {
            this.item = element;
            this.prev = prev;
        }
    }
}
