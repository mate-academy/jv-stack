package core.stack;

import java.util.EmptyStackException;

public class MateStack<T> {
    private Node<T> top;
    private int size;

    private static class Node<T> {
        private final T value;
        private Node<T> prev;

        Node(T element, Node top) {
            this.value = element;
            this.prev = top;
        }
    }

    public void push(T value) {
        Node<T> node = new Node<>(value, top);
        top = node;
        size++;
    }

    public T peek() {
        try {
            return top.value;
        } catch (NullPointerException e) {
            throw new EmptyStackException();
        }
    }

    public T pop() {
        try {
            T saveValue = top.value;
            top = top.prev;
            size--;
            return saveValue;
        } catch (NullPointerException e) {
            throw new EmptyStackException();
        }
    }

    public int size() {
        return size;
    }
}
