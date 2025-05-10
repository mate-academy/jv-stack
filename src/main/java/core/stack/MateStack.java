package core.stack;

import java.util.EmptyStackException;

public class MateStack<T> {
    private Node<T> top;
    private int size;

    private static class Node<T> {
        private T item;
        private Node<T> next;

        public Node(T item, Node<T> next) {
            this.item = item;
            this.next = next;
        }
    }

    public void push(T value) {
        top = new Node<>(value, top);
        size++;
    }

    public T peek() {
        validateSize();
        return top.item;
    }

    public T pop() {
        validateSize();
        final T result = top.item;
        top = top.next;
        size--;
        return result;
    }

    public int size() {
        return size;
    }

    private void validateSize() {
        if (size == 0) {
            throw new EmptyStackException();
        }
    }
}
