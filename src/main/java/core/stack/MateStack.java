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
        checkStackSize();
        return tail.value;
    }

    public T pop() {
        checkStackSize();
        Node<T> poppedNode = tail;
        tail = poppedNode.prev;
        size--;
        return poppedNode.value;
    }

    public int size() {
        return size;
    }

    private void checkStackSize() {
        if (size == 0) {
            throw new EmptyStackException();
        }
    }

    private static class Node<T> {
        private T value;
        private Node<T> prev;

        public Node(T value, Node<T> prev) {
            this.value = value;
            this.prev = prev;
        }
    }
}
