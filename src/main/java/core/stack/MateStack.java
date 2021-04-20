package core.stack;

import java.util.EmptyStackException;

public class MateStack<T> {
    private Node<T> top;
    private int size;

    private static class Node<T> {
        private T value;
        private Node<T> next;

        Node(T element, Node<T> next) {
            this.value = element;
            this.next = next;
        }
    }

    public void push(T value) {
        Node<T> currentNode = new Node<>(value, top);
        top = currentNode;
        size++;
    }

    public T peek() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        return top.value;
    }

    public T pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        T returnObject = top.value;
        top = top.next;
        size--;
        return returnObject;
    }

    public int size() {
        return size;
    }
}
