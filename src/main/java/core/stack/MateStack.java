package core.stack;

import java.util.EmptyStackException;

public class MateStack<T> {
    private int size;
    private Node<T> head;

    private static class Node<T> {
        T value;
        Node<T> next;

        Node(T element, Node<T> next) {
            this.next = next;
            this.value = element;
        }
    }

    public void push(T value) {
        Node<T> temp = new Node<>(value, null);
        Node<T> current = head;
        if (head == null) {
            head = temp;
        } else {

            while (current.next != null) {
                current = current.next;
            }
            current.next = temp;
        }
        size++;
    }

    public T peek() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        Node<T> current = head;
        while (current.next != null) {
            current = current.next;
        }
        return current.value;
    }

    public T pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        Node<T> current = head;
        Node<T> prev = head;

        while (current.next != null) {
            prev = current;
            current = current.next;
        }
        prev.next = null;
        size--;
        return current.value;
    }

    public int size() {
        return size;
    }
}
