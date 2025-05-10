package core.stack;

import java.util.EmptyStackException;

public class MateStack<T> {
    private int size;
    private Node<T> head;

    private static class Node<T> {
        private T value;
        private Node<T> prev;

        public Node(T value, Node<T> prev) {
            this.value = value;
            this.prev = prev;
        }
    }

    public void push(T value) {
        head = new Node<>(value, head);
        ++size;
    }

    public T peek() {
        checkSize();
        return head.value;
    }

    public T pop() {
        checkSize();
        final T result = head.value;
        head = head.prev;
        size--;
        return result;
    }

    public int size() {
        return size;
    }

    private void checkSize() {
        if (size == 0) {
            throw new EmptyStackException();
        }
    }
}
