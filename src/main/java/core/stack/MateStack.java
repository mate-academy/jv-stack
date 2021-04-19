package core.stack;

import java.util.EmptyStackException;

public class MateStack<T> {
    private Node<T> tail;
    private Node<T> head;
    private int size;

    public void push(T value) {
        Node<T> node = new Node<>(value, null);
        if (head == null) {
            head = node;
        } else {
            node.previous = tail;
        }
        tail = node;
        size++;
    }

    public T peek() {
        checkIfStackIsEmpty();
        return tail.value;
    }

    public T pop() {
        checkIfStackIsEmpty();
        Node<T> poppedNode = tail;
        tail = tail.previous;
        poppedNode.previous = null;
        size--;
        return poppedNode.value;
    }

    public int size() {
        return size;
    }

    private void checkIfStackIsEmpty() {
        if (size == 0) {
            throw new EmptyStackException();
        }
    }

    private static class Node<T> {
        private final T value;
        private Node<T> previous;

        public Node(T value, Node<T> previous) {
            this.value = value;
            this.previous = previous;
        }
    }
}
