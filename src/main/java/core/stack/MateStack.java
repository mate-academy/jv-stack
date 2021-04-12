package core.stack;

import java.util.EmptyStackException;

public class MateStack<T> {
    private Node<T> top;
    private int size;

    public void push(T value) {
        Node<T> newNode = new Node<>(value, top);
        top = newNode;
        size++;
    }

    public T peek() {
        isEmptyStack();
        return top.value;
    }

    public T pop() {
        isEmptyStack();
        T oldValue = top.value;
        top = top.next;
        size--;
        return oldValue;
    }

    public int size() {
        return size;
    }

    private void isEmptyStack() {
        if (top == null) {
            throw new EmptyStackException();
        }
    }

    private static class Node<T> {
        private T value;
        private Node<T> next;

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }
}
