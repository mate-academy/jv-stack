package core.stack;

import java.util.EmptyStackException;

public class MateStack<T> {
    private Node<T> first;
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
        first = new Node<>(value, first);
        size++;
    }

    public T peek() {
        if (size != 0) {
            return first.value;
        }
        throw new EmptyStackException();
    }

    public T pop() {
        T removedElement = peek();
        deleteElement();
        size--;
        return removedElement;
    }

    public int size() {
        return size;
    }

    private void deleteElement() {
        first = first.next;
    }
}
