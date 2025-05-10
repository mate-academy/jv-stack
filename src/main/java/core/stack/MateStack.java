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
        return top.item;
    }

    public T pop() {
        checkSize();
        final T result = top.item;
        top = top.previous;
        size--;
        return result;
    }

    public int size() {
        return size;
    }

    private static class Node<T> {
        private T item;
        private Node<T> previous;

        public Node(T item, Node<T> previous) {
            this.item = item;
            this.previous = previous;
        }
    }

    private void checkSize() {
        if (size == 0) {
            throw new EmptyStackException();
        }
    }
}
