package core.stack;

import java.util.EmptyStackException;

public class MateStack<T> {
    private Node<T> top;
    private int size;

    public static class Node<T> {
        private Node<T> prev;
        private T value;

        public Node() {
        }

        public Node(T value, Node prev) {
            this.prev = prev;
            this.value = value;
        }
    }

    public void push(T value) {
        if (size == 0) {
            Node<T> node = top;
            top = new Node<>();
            top.value = value;
            top.prev = node;
            size++;
            return;
        }
        Node<T> newNode = new Node<>();
        newNode.value = value;
        newNode.prev = top;
        top = newNode;
        size++;
    }

    public T peek() {
        checkEmpty();
        return top.value;
    }

    public T pop() {
        checkEmpty();
        Node<T> currentNodeValue = new Node<>();
        currentNodeValue.value = top.value;
        top = top.prev;
        size--;
        return currentNodeValue.value;
    }

    public int size() {
        return (size == 0) ? 0 : size;
    }

    private void checkEmpty() {
        if (size == 0) {
            throw new EmptyStackException();
        }
    }
}
