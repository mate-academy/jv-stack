package core.stack;

import java.util.EmptyStackException;

public class MateStack<T> {
    private Node<T> top;
    private int size;

    public void push(T value) {
        top = new Node<>(value, top);
        size++;
    }

    public T peek() {
        checkSize();
        return top.value;
    }

    public T pop() {
        checkSize();
        T value = top.value;
        top = top.top;
        size--;
        return value;
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
        private Node<T> top;

        public Node(T value, Node<T> previous) {
            this.value = value;
            this.top = previous;
        }
    }
}
