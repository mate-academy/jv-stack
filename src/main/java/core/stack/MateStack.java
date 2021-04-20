package core.stack;

import java.util.EmptyStackException;

public class MateStack<T> {
    private Node<T> tail;
    private int size;

    public void push(T value) {
        Node<T> newElement = new Node<>(value, tail);
        tail = newElement;
        size++;
    }

    public T peek() {
        checkException();
        return tail.item;
    }

    public T pop() {
        checkException();
        Node<T> oldElement = tail;
        tail = tail.next;
        size--;
        return oldElement.item;
    }

    public int size() {
        return size;
    }

    private class Node<T> {
        private T item;
        private Node<T> next;

        public Node(T item, Node<T> next) {
            this.item = item;
            this.next = next;
        }
    }

    private void checkException() {
        if (size == 0) {
            throw new EmptyStackException();
        }
    }
}
