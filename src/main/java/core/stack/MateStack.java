package core.stack;

import java.util.EmptyStackException;

public class MateStack<T> {
    private Node<T> tail;
    private int size;

    private static class Node<T> {
        private T value;
        private Node<T> previousNode;

        private Node(Node previousNode, T value) {
            this.previousNode = previousNode;
            this.value = value;
        }
    }

    public void push(T value) {
        tail = new Node(tail, value);
        size++;
    }

    public T peek() {
        isEmptyStack();
        return tail.value;
    }

    public T pop() {
        isEmptyStack();
        Node temp = tail;
        tail = tail.previousNode;
        size--;
        return (T) temp.value;
    }

    public int size() {
        return size;
    }

    private void isEmptyStack() {
        if (size == 0) {
            throw new EmptyStackException();
        }
    }
}
