package core.stack;

import java.util.EmptyStackException;

public class MateStack<T> {
    private Node<T> top;
    private int size;

    private static class Node<T> {
        private T value;
        private Node<T> next;

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }

    public void push(T value) {
        Node<T> newNode = new Node<T>(value, top);
        top = newNode;
        size++;
    }

    public T peek() {
        if (top == null) {
            throw new EmptyStackException();
        }
        return top.value;
    }

    public T pop() {
        T oldNode = peek();
        top = top.next;
        size--;
        return oldNode;
    }

    public int size() {
        return size;
    }
}
