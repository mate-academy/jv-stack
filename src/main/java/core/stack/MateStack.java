package core.stack;

import java.util.EmptyStackException;

public class MateStack<T> {
    private Node<T> tail;
    private int size;

    public void push(T value) {
        Node<T> newNode = new Node<>(tail, value);
        tail = newNode;
        size++;
    }

    public T peek() {
        sizeChecker(size);
        return tail.item;
    }

    public T pop() {
        sizeChecker(size);
        T retValue = tail.item;
        tail = tail.prev;
        size--;
        return retValue;
    }

    public int size() {
        return size;
    }

    private void sizeChecker(int size) {
        if (size == 0) {
            throw new EmptyStackException();
        }
    }

    private static class Node<T> {
        private Node<T> prev;
        private T item;

        public Node(Node<T> prev, T value) {
            this.prev = prev;
            this.item = value;
        }
    }
}
