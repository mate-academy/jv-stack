package core.stack;

import java.util.EmptyStackException;

public class MateStack<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size = 0;

    private static class Node<T> {
        private T value;
        private Node<T> prev;

        public Node(T value, Node<T> prev) {
            this.value = value;
            this.prev = prev;
        }
    }

    public void push(T value) {
        Node<T> newNode = new Node<>(value, null);
        if (size == 0) {
            head = newNode;
        } else {
            newNode.prev = tail;
        }
        tail = newNode;
        size++;
    }

    public T peek() {
        checkNull();
        return tail.value;
    }

    public T pop() {
        checkNull();
        Node<T> current = tail;
        tail = tail.prev;
        size--;
        return current.value;
    }

    public int size() {
        return size;
    }

    private void checkNull() {
        if (size == 0) {
            throw new EmptyStackException();
        }
    }
}
