package core.stack;

import java.util.EmptyStackException;

public class MateStack<T> {
    private int size;
    private Node<T> first;

    public void push(T value) {
        first = new Node<>(value, first);
        size++;
    }

    public T peek() {
        emptyStack();
        return first.value;
    }

    public T pop() {
        emptyStack();
        T value = first.value;
        first = first.next;
        size--;
        return value;
    }

    public int size() {
        return size;
    }

    private void emptyStack() {
        if (size == 0) {
            throw new EmptyStackException();
        }
    }

    private static class Node<T> {
        private T value;
        private  Node next;

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }
}
