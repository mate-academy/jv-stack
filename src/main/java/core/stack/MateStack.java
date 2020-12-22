package core.stack;

import java.util.EmptyStackException;

public class MateStack<T> {
    private Node<T> tail;
    private int size;

    private static class Node<T> {
        private T value;
        private Node<T> previousNode;

        public Node(Node previousNode, T value) {
            this.previousNode = previousNode;
            this.value = value;
        }
    }

    public void push(T value) {
        Node newNode = new Node(null, value);
        if (tail == null) {
            tail = newNode;
        } else {
            newNode.previousNode = tail;
            tail = newNode;
        }
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

    public void isEmptyStack() {
        if (size == 0) {
            throw new EmptyStackException();
        }
    }
}
