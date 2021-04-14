package core.stack;

import java.util.EmptyStackException;

public class MateStack<T> {
    private Node<T> element;
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
        element = new Node<>(value, element);
        size++;
    }

    public T peek() {
        isEmpty();
        return element.item;
    }

    public T pop() {
        isEmpty();
        final T result = element.item;
        element = element.next;
        size--;
        return result;
    }

    public int size() {
        return size;
    }

    public void isEmpty() {
        if (size == 0) {
            throw new EmptyStackException();
        }
    }
}
