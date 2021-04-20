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
        checkSize();
        return top.value;
    }

    public T pop() {
        checkSize();
        T returnObject = top.value;
        top = top.next;
        size--;
        return returnObject;
    }

    public int size() {
        return size;
    }

    private void checkSize() {
        if (size == 0) {
            throw new EmptyStackException();
        }
    }
}
