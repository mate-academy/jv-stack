package core.stack;

import java.util.EmptyStackException;

public class MateStack<T> {
    private Node<T> head;
    private int size;

    public MateStack() {
        this.size = 0;
    }

    public void push(T value) {
        Node<T> newNode = new Node<>(value, head);
        head = newNode;
        size++;
    }

    public T peek() {
        checkLength();
        return head.value;
    }

    public T pop() {
        checkLength();
        size--;
        Node<T> removedNode = head;
        head = head.prev;
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
