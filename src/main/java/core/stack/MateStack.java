package core.stack;

import java.util.EmptyStackException;

public class MateStack<T> {
    private Node<T> top;
    private int size;

    public void push(T value) {
        top = new Node<>(top, value);
        size++;
    }

    public T peek() {
        if (isStackEmpty()) {
            throw new EmptyStackException();
        }
        return top.item;
    }

    public T pop() {
        if (isStackEmpty()) {
            throw new EmptyStackException();
        }
        T value = peek();
        top = top.prev;
        size--;
        return value;
    }

    public int size() {
        return size;
    }

    public boolean isStackEmpty() {
        return size == 0;
    }

    private class Node<E> {
        private E item;
        private Node<E> prev;

        Node(Node<E> prev, E element) {
            this.item = element;
            this.prev = prev;
        }
    }
}
