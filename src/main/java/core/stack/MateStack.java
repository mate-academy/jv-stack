package core.stack;

import java.util.EmptyStackException;

public class MateStack<T> {

    private Node<T> tail;
    private int size;

    public void push(T value) {
        Node<T> newNode;
        if (tail == null) {
            newNode = new Node<>(value, null);
        } else {
            newNode = new Node<>(value, tail);
        }
        tail = newNode;
        size++;
    }

    public T peek() {
        checkSize();
        return tail.value;
    }

    public T pop() {
        checkSize();
        Node<T> removeNode = tail;
        tail = removeNode.prevNode;
        size--;
        return removeNode.value;

    }

    private void checkSize() {
        if (size == 0) {
            throw new EmptyStackException();
        }
    }

    public int size() {
        return size;
    }

    private class Node<T> {
        private T value;
        private Node<T> prevNode;

        public Node(T value, Node<T> prevNode) {
            this.value = value;
            this.prevNode = prevNode;
        }
    }
}
