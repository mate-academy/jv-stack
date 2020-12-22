package core.stack;

import java.util.EmptyStackException;

public class MateStack<T> {
    private Node<T> tail;
    private int size;
    
    public void push(T value) {
        tail = new Node<>(tail, value);
        size++;
    }

    public T peek() {
        checkValidSize(size);
        return tail.value;
    }

    public T pop() {
        checkValidSize(size);
        T removedObject = tail.value;
        tail = tail.previous;
        size--;
        return removedObject;
    }

    public int size() {
        return size;
    }

    public void checkValidSize(int size) {
        if (size == 0) {
            throw new EmptyStackException();
        }
    }

    private static class Node<T> {
        private Node<T> previous;
        private T value;

        public Node(Node<T> prev, T value) {
            this.previous = prev;
            this.value = value;
        }
    }
}
