package core.stack;

import java.util.EmptyStackException;

public class MateStack<T> {
    private Node<T> top;
    private int size;

    public static class Node<T> {
        private Node<T> next;
        private T value;

        public Node(T value, Node next) {
            this.next = next;
            this.value = value;
        }
    }


    public void push(T value) {
        Node<T> newNode = new Node<>(value,top);
        top = newNode;
        size++;
    }

    public T peek() {
        checkEmpty();
        return top.value;
    }

    public T pop() {
        checkEmpty();
        Node<T> currentNodeValue = top;
        top = top.next;
        size--;
        return currentNodeValue.value;
    }

    public int size() {
        return (size == 0) ? 0 : size;
    }

    private void checkEmpty() {
        if (size == 0) {
            throw new EmptyStackException();
        }
    }
}
