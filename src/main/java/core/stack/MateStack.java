package core.stack;

import java.util.EmptyStackException;

public class MateStack<T> {
    private int size;
    private Node<T> tail;

    public void push(T value) {
        tail = new Node<T>(value, tail);
        size++;
    }

    public T peek() {
        ifEmpty();
        return tail.value;
    }

    public T pop() {
        ifEmpty();
        Node<T> temp = tail;
        tail = tail.prev;
        size--;
        return temp.value;
    }

    public int size() {
        return size;
    }

    private static class Node<T> {
        T value;
        Node<T> prev;

        Node(T element, Node<T> prev) {
            this.prev = prev;
            this.value = element;
        }
    }

    private void ifEmpty() {
        if (size == 0) {
            throw new EmptyStackException();
        }
    }
}
