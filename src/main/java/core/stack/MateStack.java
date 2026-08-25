package core.stack;

import java.util.EmptyStackException;

public class MateStack<T> {

    private Node<T> head;
    private int size;

    private static class Node<T> {
        private final T value;
        private final Node<T> next;

        Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }

    public void push(T value) {
        head = new Node<>(value, head);
        size++;
    }

    public T peek() {
        if (head == null) {
            throw new EmptyStackException();
        }
        return head.value;
    }

    public T pop() {
        if (head == null) {
            throw new EmptyStackException();
        }
        T value = head.value;
        head = head.next;
        size--;
        return value;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return head == null;
    }
}
