package core.stack;

import java.util.EmptyStackException;

public class MateStack<T> {
    private int size;
    private Node<T> tail;

    public void push(T value) {
        tail = new Node<>(tail, value);
        size++;
    }

    public T peek() {
        checkSize();
        return tail.value;
    }

    public T pop() {
        T resultValue = peek();
        tail = tail.prev;
        size--;
        return resultValue;
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
        private Node<T> prev;
        private T value;

        public Node(Node<T> prev, T value) {
            this.prev = prev;
            this.value = value;
        }
    }
}
