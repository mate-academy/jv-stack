package core.stack;

import java.util.EmptyStackException;

public class MateStack<T> {
    private Node<T> top;
    private int size;

    public void push(T value) {
        top = new Node<>(value, top);;
        size++;
    }

    public T peek() {
        isSizeValid();
        return top.value;
    }

    public T pop() {
        isSizeValid();
        T value = top.value;
        top = top.prev;
        size--;
        return value;
    }

    public int size() {
        return size;
    }

    private void isSizeValid() {
        if (size <= 0) {
            throw new EmptyStackException();
        }
    }

    private class Node<T> {
        private T value;
        private Node<T> prev;

        public Node(T value, Node<T> prev) {
            this.value = value;
            this.prev = prev;
        }
    }
}
