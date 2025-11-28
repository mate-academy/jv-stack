package core.stack;

import java.util.EmptyStackException;

public class MateStack<T> {
    // Node for singly linked list
    private static class Node<T> {
        T value;
        Node<T> next;

        Node(T value) {
            this.value = value;
        }
    }

    private Node<T> top;  // top of stack
    private int size;     // stack size

    public MateStack() {
        this.top = null;
        this.size = 0;
    }

    public void push(T value) {
        Node<T> newNode = new Node<>(value);
        newNode.next = top;
        top = newNode;
        size++;
    }

    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();   // required by tests
        }
        return top.value;
    }

    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();   // required by tests
        }
        T value = top.value;
        top = top.next;
        size--;
        return value;
    }

    public int size() {
        return size;
    }

    private boolean isEmpty() {
        return size == 0;
    }
}
