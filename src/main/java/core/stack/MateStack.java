package core.stack;

import java.util.EmptyStackException;

public class MateStack<T> {
    private Node<T> lastNode;
    private int size;

    public void push(T value) {
        lastNode = new Node<>(lastNode, value);
        size++;
    }

    public T peek() {
        sizeCheck();
        return lastNode.value;
    }

    public T pop() {
        sizeCheck();
        Node<T> oldNode = lastNode;
        lastNode = lastNode.previous;
        size--;
        return oldNode.value;
    }

    public int size() {
        return size;
    }

    private void sizeCheck() {
        if (size == 0) {
            throw new EmptyStackException();
        }
    }

    private static class Node<T> {
        private T value;
        private Node<T> previous;

        public Node(Node<T> previous, T value) {
            this.previous = previous;
            this.value = value;
        }
    }
}
