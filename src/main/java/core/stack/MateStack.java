package core.stack;

import java.util.EmptyStackException;

public class MateStack<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public void push(T value) {
        Node<T> newNode = new Node(null, value);
        if (size == 0) {
            head = newNode;
        } else {
            tail.nextNode = newNode;
        }
        tail = newNode;
        size++;
    }

    public T peek() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        return tail.value;
    }

    public T pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        Node<T> currentNode = head;
        while (currentNode.nextNode != null && currentNode.nextNode != tail) {
            currentNode = currentNode.nextNode;
        }
        T tailValue = tail.value;
        tail = currentNode;
        size--;
        return tailValue;
    }

    public int size() {
        return size;
    }

    public static class Node<T> {
        private Node<T> nextNode;
        private final T value;

        public Node(Node<T> nextNode, T value) {
            this.nextNode = nextNode;
            this.value = value;
        }
    }
}
