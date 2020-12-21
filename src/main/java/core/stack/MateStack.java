package core.stack;

import java.util.EmptyStackException;

public class MateStack<T> {
    private Node<T> tail;
    private int size;

    private static class Node<T> {
        private final T value;
        private Node<T> prev;

        public Node(T value) {
            this.value = value;
        }
    }

    public MateStack() {
        tail = null;
    }

    public void push(T value) {
        Node<T> newNode = new Node<>(value);
        newNode.prev = tail;
        tail = newNode;
        size++;
    }

    public T peek() {
        checkForEmptyStack();
        return tail.value;
    }

    public T pop() throws EmptyStackException {
        checkForEmptyStack();
        final T resultValue = tail.value;
        Node<T> temporaryNode = tail.prev;
        tail = null;
        size--;
        tail = temporaryNode;
        return resultValue;
    }

    public int size() {
        return size;
    }

    private boolean isEmpty() {
        return size == 0;
    }

    private void checkForEmptyStack() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
    }
}
