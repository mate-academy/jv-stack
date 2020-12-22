package core.stack;

import java.util.EmptyStackException;

public class MateStack<T> {
    private Node<T> tail;
    private int size;

    public void push(T value) {
        tail = new Node<>(tail, value);
        size++;
    }

    public T peek() {
        return stackIsNotEmpty() ? tail.value : null;
    }

    public T pop() {
        T value = null;
        if (stackIsNotEmpty()) {
            value = tail.value;
            Node<T> oldNode = tail;
            tail = oldNode.prev;
        }
        size--;
        return value;
    }

    public int size() {
        return size;
    }

    private static class Node<T> {
        private T value;
        private Node<T> prev;

        public Node(Node<T> prev, T value) {
            this.prev = prev;
            this.value = value;
        }
    }

    private boolean stackIsNotEmpty() {
        if (size != 0) {
            return true;
        }
        throw new EmptyStackException();
    }
}
