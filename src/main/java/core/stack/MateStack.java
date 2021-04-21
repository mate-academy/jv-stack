package core.stack;

import java.util.EmptyStackException;

public class MateStack<T> {
    private Node<T> top;
    private int size;

    public void push(T value) {
        Node<T> node = new Node<>(value, top);
        top = node;
        size++;
    }

    public T peek() {
        checkSize();
        return top.value;
    }

    public T pop() {
        checkSize();
        T saveValue = top.value;
        top = top.prev;
        size--;
        return saveValue;
    }

    public int size() {
        return size;
    }

    private static class Node<T> {
        private final T value;
        private Node<T> prev;

        Node(T element, Node top) {
            this.value = element;
            this.prev = top;
        }
    }

    public void checkSize() {
        if (size == 0) {
            throw new EmptyStackException();
        }
    }
}
