package core.stack;

import java.util.EmptyStackException;

public class MateStack<T> {
    private int size;
    private Node<T> head;

    static class Node<T> {
        private T value;
        private Node<T> next;
        private Node<T> previous;

        Node(T value) {
            this.value = value;
        }
    }

    public void push(T value) {
        Node<T> newNode = new Node(value);
        if (head != null) {
            newNode.previous = head;
            head.next = newNode;
        }
        head = newNode;
        size++;
    }

    public T peek() {
        if (head != null) {
            return head.value;
        }
        throw new EmptyStackException();
    }

    public T pop() {
        if (head != null) {
            size--;
            T deletedValue = head.value;
            if (head.previous != null) {
                head = head.previous;
            }
            head.next = null;
            return deletedValue;
        }
        throw new EmptyStackException();
    }

    public int size() {
        return size;
    }
}
