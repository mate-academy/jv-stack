package core.stack;

import java.util.EmptyStackException;

public class MateStack<T> {
    private static class Node<T> {
        private T value;
        private Node<T> next;

        Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }

        public T getValue() {
            return value;
        }

        public Node<T> getNext() {
            return next;
        }
    }

    private Node<T> head;
    private int size;

    public void push(T value) {
        head = new Node<>(value, head);
        size++;
    }

    public T peek() {
        if (head == null) {
            throw new EmptyStackException();
        }
        return head.getValue();
    }

    public T pop() {
        if (head == null) {
            throw new EmptyStackException();
        }
        T value = head.getValue();
        head = head.getNext();
        size--;
        return value;
    }

    public int size() {
        return size;
    }
}
