package core.stack;

import java.util.EmptyStackException;

public class MateStack<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public MateStack() {
        size = 0;
    }

    public void push(T value) {
        if (size == 0) {
            head = new Node<>(value, null);
            tail = head;
            size++;
            return;
        }
        tail.next = new Node<>(value, null);
        tail = tail.next;
        size++;
    }

    public T peek() {
        checkStack();
        return tail.value;
    }

    public T pop() {
        checkStack();
        Node<T> localNode = head;
        size--;
        for (int i = 0; i < size - 1; i++) {
            localNode = localNode.next;
        }
        T result = tail.value;
        tail = localNode;
        tail.next = null;
        return result;
    }

    public int size() {
        return size;
    }

    private void checkStack() {
        if (size == 0) {
            throw new EmptyStackException();
        }
    }

    private static class Node<T> {
        private T value;
        private Node<T> next;

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }
}
