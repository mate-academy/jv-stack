package core.stack;

import java.util.EmptyStackException;

public class MateStack<T> {
    private Node<T> top;
    private int size;

    private static class Node<T> {
        private final T value;
        private final Node<T> previous;

        public Node(T value, Node<T> previous) {
            this.value = value;
            this.previous = previous;
        }
    }

    public void push(T value) {
        top = new Node<>(value, top);
        size++;
    }

    public T peek() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        return top.value;
    }

    public T pop() {
        T requiredValue = peek();
        top = top.previous;
        size--;
        return requiredValue;
    }

    public int size() {
        return size;
    }
}
