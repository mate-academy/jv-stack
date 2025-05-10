package core.stack;

import java.util.EmptyStackException;

public class MateStack<T> {
    private Node<T> tail;
    private int size;

    public void push(T value) {
        tail = new Node<>(value, tail);
        size++;
    }

    public T peek() {
        checkLength();
        return tail.value;
    }

    public T pop() {
        checkLength();
        size--;
        Node<T> removedNode = tail;
        tail = tail.prev;
        return removedNode.value;
    }

    public int size() {
        return size;
    }

    private void checkLength() {
        if (size == 0) {
            throw new EmptyStackException();
        }
    }

    private static class Node<T> {
        private T value;
        private Node<T> prev;

        Node(T value, Node<T> prev) {
            this.value = value;
            this.prev = prev;
        }
    }
}
