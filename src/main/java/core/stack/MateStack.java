package core.stack;

import java.util.EmptyStackException;

public class MateStack<T> {
    private Node<T> tail;
    private int size;

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
        T resultValue = tail.value;
        tail = tail.prev;
        size--;
        return resultValue;
    }

    public int size() {
        return size;
    }

    private void checkForEmptyStack() {
        if (size == 0) {
            throw new EmptyStackException();
        }
    }

    private static class Node<T> {
        private final T value;
        private Node<T> prev;

        public Node(T value) {
            this.value = value;
        }
    }
}
