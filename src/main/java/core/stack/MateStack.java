package core.stack;

import java.util.EmptyStackException;

public class MateStack<T> {
    private int size;
    private Node<T> head;

    public void push(T value) {
        head = new Node<>(value, head);
        size++;
    }

    public T peek() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        return head.value;
    }

    public T pop() {
        T valueLastElement = peek();
        head = head.prev;
        size--;
        return valueLastElement;
    }

    public int size() {
        return size;
    }

    private static class Node<T> {
        private final T value;
        private final Node<T> prev;

        public Node(T value, Node<T> prev) {
            this.value = value;
            this.prev = prev;
        }
    }
}
