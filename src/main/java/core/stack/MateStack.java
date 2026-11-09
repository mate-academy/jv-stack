package core.stack;

import java.util.EmptyStackException;

public class MateStack<T> {
    private int size;
    private Node<T> top;

    public T push(T value) {
        top = new Node<>(value, top);
        size++;
        return value;
    }

    public T peek() {
        if (top == null) {
            throw new EmptyStackException();
        }
        T value = top.value;
        return value;
    }

    public T pop() {
        if (top == null) {
            throw new EmptyStackException();
        }
        T value = top.value;
        top = top.next;
        size--;
        return value;
    }

    public int size() {
        return size;
    }

    private static class Node<T> {
        private T value;
        private Node<T> next;

        Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }
}
