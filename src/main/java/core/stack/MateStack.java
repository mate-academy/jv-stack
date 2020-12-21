package core.stack;

import java.util.EmptyStackException;

public class MateStack<T> {
    private Node<T> pointer;
    private int size;

    public void push(T value) {
        pointer = new Node<>(pointer, value);
        size++;
    }

    public T peek() {
        checkIsEmpty();
        return pointer.value;
    }

    public T pop() {
        checkIsEmpty();
        T value = pointer.value;
        pointer = pointer.previous;
        size--;
        return value;
    }

    public int size() {
        return size;
    }

    private void checkIsEmpty() {
        if (size == 0) {
            throw new EmptyStackException();
        }
    }

    private static class Node<T> {
        private Node<T> previous;
        private T value;

        private Node(Node<T> previous, T value) {
            this.previous = previous;
            this.value = value;
        }
    }
}
