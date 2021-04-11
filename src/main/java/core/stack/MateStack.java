package core.stack;

import java.util.EmptyStackException;

public class MateStack<T> {
    private Node<T> element;
    private int size;

    private class Node<T> {
        private T item;
        private Node<T> next;

        public Node(T item, Node<T> next) {
            this.item = item;
            this.next = next;
        }
    }

    public void push(T value) {
        if (size == 0) {
            element = new Node<>(value, null);
        } else {
            element = new Node<>(value, element);
        }
        size++;
    }

    public T peek() {
        isEmpty();
        return element.item;
    }

    public T pop() {
        isEmpty();
        Node<T> removed = element;
        final T result = removed.item;
        if (removed.next == null) {
            element = null;
        } else {
            element = removed.next;
        }
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
