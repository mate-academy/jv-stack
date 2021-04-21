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
        if (size > 0) {
            return top.value;
        }
        throw new EmptyStackException();
    }

    public T pop() throws EmptyStackException {
        if (size > 0) {
            T value = top.value;
            top = top.prev;
            size--;
            return value;
        }
        throw new EmptyStackException();
    }

    public int size() {
        return size;
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
