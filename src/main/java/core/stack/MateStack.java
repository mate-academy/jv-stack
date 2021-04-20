package core.stack;

import java.util.EmptyStackException;

public class MateStack<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public void push(T value) {
        Node<T> newElement = new Node<>(value, null);
        if (size == 0) {
            tail = newElement;
            head = newElement;
        } else {
            tail.next = newElement;
            tail = newElement;
        }
        size++;
    }

    public T peek() {
        checkException();
        return tail.item;
    }

    public T pop() {
        checkException();
        Node<T> oldElement = tail;
        tail = findElement();
        tail.next = null;
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

    private Node<T> findElement() {
        Node<T> element = head;
        for (int i = 0; i < size - 2; i++) {
            element = element.next;
        }
        size--;
        return element;
    }

    private void checkException() {
        if (size == 0) {
            throw new EmptyStackException();
        }
    }
}
