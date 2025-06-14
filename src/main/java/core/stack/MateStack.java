package core.stack;

import java.util.EmptyStackException;

public class MateStack<T> {

    private Node<T> head;
    private int size;

    static class Node<T> {
        private final T value;
        private final Node<T> next;

        public Node(Node<T> next, T value) {
            this.value = value;
            this.next = next;
        }
    }

    public void push(T value) {

        Node<T> first = head;
        head = new Node<>(first, value);
        size++;

    }

    public T peek() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        return head.value;
    }

    public T pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        Node<T> newHead = head.next;
        final Node<T> headCopy = head;
        if (head.next == null) {
            newHead = head;
        }
        head = newHead;
        size--;
        return headCopy.value;
    }

    public int size() {
        return size;
    }
}

