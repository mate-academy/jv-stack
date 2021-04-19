package core.stack;

import java.util.EmptyStackException;

public class MateStack<T> {
    private int size;
    private Node<T> top;

    public MateStack() {
    }

    private static class Node<T> {
        private final T value;
        private final Node<T> next;

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }

    public void push(T value) {
        top = new Node<>(value, top);
        size++;
    }

    public T peek() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        return top.value;
    }

    public T pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        Node<T> removedNode = top;
        top = top.next;
        size--;
        return removedNode.value;
    }

    public int size() {
        return size;
    }
}
