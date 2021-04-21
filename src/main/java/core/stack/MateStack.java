package core.stack;

import java.util.EmptyStackException;

public class MateStack<T> {
    private Node<T> top;
    private int size;

    private static class Node<T> {
        private T value;
        private Node<T> next;

        private Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }

    public void push(T value) {
        top = new Node<>(value, top);
        size++;
    }

    public T peek() {
        if (size != 0) {
            return top.value;
        }
        throw new EmptyStackException();
    }

    public T pop() {
        T removedElement = peek();
        top = top.next;
        size--;
        return removedElement;
    }

    public int size() {
        return size;
    }

}
