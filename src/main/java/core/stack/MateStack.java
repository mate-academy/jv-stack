package core.stack;

import java.util.EmptyStackException;

public class MateStack<T> {
    private Node<T> top;
    private int size;

    public void push(T value) {
        Node<T> node;
        if (size == 0) {
            node = new Node<>(value, null);
        } else {
            node = new Node<>(value, top);
        }
        top = node;
        size++;
    }

    public T peek() throws EmptyStackException {
        checkIfSizeValid();
        return top.value;
    }

    public T pop() throws EmptyStackException {
        checkIfSizeValid();
        T value = top.value;
        top = top.prev;
        size--;
        return value;
    }

    public int size() {
        return size;
    }

    private void checkIfSizeValid() {
        if (size <= 0) {
            throw new EmptyStackException();
        }
    }

    private class Node<T> {
        private T value;
        private Node<T> prev;

        public Node(T value, Node<T> prev) {
            this.value = value;
            this.prev = prev;
        }
    }
}
