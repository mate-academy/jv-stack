package core.stack;

import java.util.EmptyStackException;

public class MateStack<T> {
    private Node<T> tail;
    private int size;

    public void push(T value) {
        if (tail == null) {
            tail = new Node<>(value, null);
        } else {
            tail = new Node<>(value, tail);
        }
        size++;
    }

    public T peek() {
        checkSize();
        return tail.value;
    }

    public T pop() {
        checkSize();
        T element = tail == null ? null : tail.value;
        tail = tail == null ? null : tail.prev;
        size--;
        return element;
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
        private T value;
        private Node<T> prev;

        private Node(T value, Node<T> prev) {
            this.value = value;
            this.prev = prev;
        }
    }
}
