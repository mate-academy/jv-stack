package core.stack;

import java.util.EmptyStackException;

public class MateStack<T> {
    private Node<T> tail;
    private int size;

    public void push(T value) {
        tail = new Node<>(tail, value);
        size++;
    }

    public T peek() {
        checkStackSize();
        return tail.value;
    }

    public T pop() {
        checkStackSize();
        Node<T> oldNode = tail;
        tail = oldNode.prev;
        size--;
        return oldNode.value;
    }

    public int size() {
        return size;
    }

    private static class Node<T> {
        private T value;
        private Node<T> prev;

        public Node(Node<T> prev, T value) {
            this.prev = prev;
            this.value = value;
        }
    }

    private void checkStackSize() {
        if (size != 0) {
            return;
        }
        throw new EmptyStackException();
    }
}
