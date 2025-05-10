package core.stack;

import java.util.EmptyStackException;

public class MateStack<T> {
    private Node<T> tail;
    private int size;

    public MateStack() {
        size = 0;
    }

    public void push(T value) {
        tail = new Node<>(value, tail);
        size++;
    }

    public T peek() {
        checkStack();
        return tail.value;
    }

    public T pop() {
        checkStack();
        size--;
        T result = tail.value;
        tail = tail.prev;
        return result;
    }

    public int size() {
        return size;
    }

    private void checkStack() {
        if (size == 0) {
            throw new EmptyStackException();
        }
    }

    private static class Node<T> {
        private T value;
        private Node<T> prev;

        Node(T value, Node<T> prev) {
            this.value = value;
            this.prev = prev;
        }
    }
}
