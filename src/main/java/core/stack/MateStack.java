package core.stack;

import java.util.EmptyStackException;

public class MateStack<T> {
    private Node<T> top;
    private int size;
    
    public void push(T value) {
        top = new Node<>(value, top);
        size++;
    }

    public T peek() {
        checkSize();
        return top.value;
    }

    public T pop() {
        checkSize();
        T element = peek();
        top = top.prev;
        size--;
        return element;
    }

    public int size() {
        return size;
    }

    private void checkSize() {
        if (size == 0) {
            throw new EmptyStackException();
        }
    }

    private static class Node<T> {
        private T value;
        private Node<T> prev;

        private Node(T value, Node<T> prev) {
            this.value = value;
            this.prev = prev;
        }
    }
}
