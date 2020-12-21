package core.stack;

import java.util.EmptyStackException;

public class MateStack<T> {
    private int size;
    private Node<T> tail;

    public void push(T value) {
        tail = new Node<>(value, tail);
        size++;
    }

    public T peek() {
        isEmpty();
        return tail.value;
    }

    public T pop() {
        isEmpty();
        Node<T> currentNode = tail;
        tail = currentNode.previous;
        currentNode.previous = null;
        size--;
        return currentNode.value;
    }

    public int size() {
        return size;
    }

    private static class Node<V> {
        private V value;
        private Node<V> previous;

        public Node(V value, Node<V> previous) {
            this.value = value;
            this.previous = previous;
        }
    }

    private void isEmpty() {
        if (size > 0) {
            return;
        }
        throw new EmptyStackException();
    }
}
