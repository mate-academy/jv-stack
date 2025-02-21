package core.stack;

import java.util.EmptyStackException;

public class MateStack<T> {

    private static class Node<T> {
        T value;
        Node<T> next;

        Node(T value) {
            this.value = value;
        }
    }

    private Node<T> top;
    private int size;

    public MateStack() {
        top = null;
        size = 0;
    }

    public void push(T value) {
        Node<T> newNode = new Node<>(value);
        newNode.next = top;
        top = newNode;
        size++;
    }

    public T peek() {
        if (top == null) {
            throw new EmptyStackException();
        }
        return top.value;
    }

    public T pop() {
        if (top == null) {
            throw new EmptyStackException();
        }
        T value = top.value;
        top = top.next;
        size--;
        return value;
    }

    public int size() {
        return size;
    }
}
