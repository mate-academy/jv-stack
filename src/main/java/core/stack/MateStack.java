package core.stack;

import java.util.EmptyStackException;

public class MateStack<T> {
    private int size;
    private Node<T> top;

    public MateStack() {
        this.size = 0;
    }

    public void push(T value) {
        top = new Node<>(value, top);
        size++;
    }

    public T peek() {
        if (size != 0) {
            return top.value;
        }
        throw new EmptyStackException();
    }

    public T pop() {
        if (size != 0) {
            T value = top.value;
            top = top.prev;
            size--;
            return value;
        }
        throw new EmptyStackException();
    }

    public int size() {
        return size;
    }

    private static class Node<T> {
        private final T value;
        private final Node<T> prev;

        Node(T value, Node<T> prev) {
            this.value = value;
            this.prev = prev;
        }
    }
}
