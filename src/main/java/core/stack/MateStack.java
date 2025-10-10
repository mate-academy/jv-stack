package core.stack;

import java.util.EmptyStackException;

public class MateStack<T> {

    private Node<T> head;
    private int size;

    public void push(T value) {
        Node<T> newNode = new Node<>(value);
        if (head == null) {
            head = newNode;
        } else {
            newNode.prev = head;
            head = newNode;
        }
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
        Node<T> removedNode = head;
        head = head.prev;
        size--;
        return removedNode.value;
    }

    public int size() {
        return size;
    }

    private class Node<T> {
        private T value;
        private Node<T> prev;

        public Node(T value) {
            this.value = value;
        }
    }
}
