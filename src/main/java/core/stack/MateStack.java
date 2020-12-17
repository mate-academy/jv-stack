package core.stack;

import java.util.EmptyStackException;

public class MateStack<T> {
    private int size;
    private Node<T> tail;

    public MateStack() {
        tail = new Node<>(null, null);
    }

    public void push(T value) {
        if (size == 0) {
            tail.value = value;
            size++;
            return;
        }
        Node<T> tempNode = new Node<>(tail, value);
        tail = tempNode;
        size++;

    }

    public T peek() {
        checkSize();
        return tail.value;
    }

    public T pop() {
        checkSize();
        T resultValue = peek();
        tail = tail.prev;
        size--;
        return resultValue;
    }

    private void checkSize() {
        if (size == 0) {
            throw new EmptyStackException();
        }
    }

    public int size() {
        return size;
    }

    private static class Node<T> {
        Node<T> prev;
        T value;

        public Node(Node<T> prev, T value) {
            this.prev = prev;
            this.value = value;
        }
    }
}
