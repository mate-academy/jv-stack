package core.stack;

import java.util.EmptyStackException;

public class MateStack<T> {

    private Node top;
    private int size;

    private class Node {
        private T value;
        private Node next;
    }

    public void push(T value) {
        Node newNode = new Node();
        newNode.next = top;
        newNode.value = value;
        top = newNode;
        size++;
    }

    public T peek() {
        if (top == null) {
            throw new EmptyStackException();
        } else {
            return top.value;
        }
    }

    public T pop() {
        if (top == null) {
            throw new EmptyStackException();
        } else {
            T value = top.value;
            top = top.next;
            size--;

            return value;
        }
    }

    public int size() {
        return size;
    }
}
