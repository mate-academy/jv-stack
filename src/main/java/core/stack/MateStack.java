package core.stack;

import java.util.EmptyStackException;

public class MateStack<T> {
    private int size;
    private Node<T> stack;

    public void push(T value) {
        stack = new Node<>(value, stack);
        size++;
    }

    public T peek() {
        nullCheck();
        return stack.value;
    }

    public T pop() {
        nullCheck();
        Node<T> result = stack;
        stack = stack.prev;
        size--;
        return result.value;
    }

    public int size() {
        return size;
    }

    private static class Node<T> {
        private T value;
        private Node<T> prev;

        Node(T value, Node<T> prev) {
            this.value = value;
            this.prev = prev;
        }
    }

    private void nullCheck() {
        if (stack == null) {
            throw new EmptyStackException();
        }
    }
}
