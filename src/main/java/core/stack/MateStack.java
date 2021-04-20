package core.stack;

import java.util.EmptyStackException;

public class MateStack<T> {
    private int size;
    private Node<T> head;

    private static class Node<T> {
        private T value;
        private Node<T> next;

        Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }

    public void push(T value) {
        head = (Node<T>) new Node(value, head);
        size++;
    }

    public T peek() {
        checkForHead();
        return head.value;
    }

    public T pop() {
        checkForHead();
        size--;
        T deletedValue = head.value;
        head = head.next;
        return deletedValue;
    }

    private void checkForHead() {
        if (head == null) {
            throw new EmptyStackException();
        }
    }

    public int size() {
        return size;
    }
}
