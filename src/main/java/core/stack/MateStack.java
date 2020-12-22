package core.stack;

import java.util.EmptyStackException;

public class MateStack<T> {
    private Node<T> tail;
    private int size;

    public void push(T value) {
        tail = new Node<>(tail, value);
        size++;
    }

    public T peek() {
        checkStackSize();
        return tail.value;
    }

    public T pop() {
        checkStackSize();
        Node<T> oldValue = tail;
        tail = tail.prev;
        size--;
        return oldValue.value;
    }

    public int size() {
        return size;
    }

    private void checkStackSize() {
        if (size == 0) {
            throw new EmptyStackException();
        }
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
