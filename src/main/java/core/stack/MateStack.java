package core.stack;

import java.util.EmptyStackException;

public class MateStack<T> {
    private int size;
    private Node<T> top;

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
        T removedValue = peek();
        top = top.next;
        size--;
        return removedValue;
    }

    public int size() {
        return size;
    }
}
