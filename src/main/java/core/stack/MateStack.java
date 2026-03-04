package core.stack;

import java.util.EmptyStackException;

public class MateStack<T> {
    private static final int VALUE_ZERO = 0;
    private Node<T> top;
    private int size;

    private static class Node<T> {
        private final T value;
        private final Node<T> next;

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }

    public void push(T value) {
        top = new Node<>(value, top);
        size++;
    }

    public T peek() {
        if (size == VALUE_ZERO) {
            throw new EmptyStackException();
        }
        return top.value;
    }

    public T pop() {
        if (size == VALUE_ZERO) {
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
}
