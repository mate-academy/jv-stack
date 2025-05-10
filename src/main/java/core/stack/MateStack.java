package core.stack;

import java.util.EmptyStackException;

public class MateStack<T> {
    private Node<T> tail;
    private int size = 0;

    public void push(T value) {
        Node<T> newNode = new Node<>(value, null);
        newNode.prev = tail;
        tail = newNode;
        size++;
    }

    public T peek() {
        checkNull();
        return tail.value;
    }

    public int size() {
        return size;
    }

    public T pop() {
        checkNull();
        Node<T> current = tail;
        tail = tail.prev;
        size--;
        return current.value;
    }

    private void checkNull() {
        if (size == 0) {
            throw new EmptyStackException();
        }
    }

    private static class Node<T> {
        private T value;
        private Node<T> prev;

        private Node(T value, Node<T> prev) {
            this.value = value;
            this.prev = prev;
        }
    }
}
