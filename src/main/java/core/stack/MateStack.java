package core.stack;

import java.util.EmptyStackException;

public class MateStack<T> {
    private Node<T> top;
    private int size;

    public void push(T value) {
        Node<T> newNode = new Node<>(value);
        newNode.setNext(top);
        top = newNode;
        size++;
    }

    private static class Node<T> {
        final T value;
        private Node<T> next;

        Node(T value) {
            this.value = value;
        }

        public T getValue() {
            return value;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }
    }

    public T peek() {
        if (top == null) {
            throw new EmptyStackException();
        }
        return top.getValue();
    }

    public T pop() {
        if (top == null) {
            throw new EmptyStackException();
        }

        T value = top.getValue();
        top = top.getNext();
        size--;
        return value;
    }

    public int size() {
        return size;
    }
}
