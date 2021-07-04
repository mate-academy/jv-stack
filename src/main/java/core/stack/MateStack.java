package core.stack;

import java.util.EmptyStackException;

public class MateStack<T> {
    private int size;
    private Node<T> topNode;

    private static class Node<T> {
        private T value;
        private Node<T> prevNode;

        public Node(T value, Node<T> prevNode) {
            this.value = value;
            this.prevNode = prevNode;
        }
    }

    public void push(T value) {
        Node<T> newNode = new Node<>(value, topNode);
        topNode = newNode;
        size++;
    }

    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return topNode.value;
    }

    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        T tempvalue = topNode.value;
        topNode = topNode.prevNode;
        size--;
        return tempvalue;
    }

    private boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }
}
