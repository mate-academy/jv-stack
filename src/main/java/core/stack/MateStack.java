package core.stack;

import java.util.EmptyStackException;

public class MateStack<T> {
    private Node<T> head;
    private int size;

    public void push(T value) {
        head = new Node<>(value, head);
        size++;
    }

    public T peek() {
        checkSizeIsNotEmpty();
        return head.value;
    }

    public T pop() {
        checkSizeIsNotEmpty();
        T lastValue = head.value;
        head = head.prev;
        size--;
        return lastValue;
    }

    public int size() {
        return size;
    }

    private class Node<T> {
        private T value;
        private Node<T> prev;

        public Node(T value, Node<T> next) {
            this.value = value;
            this.prev = next;
        }
    }

    private void checkSizeIsNotEmpty() {
        if (size == 0) {
            throw new EmptyStackException();
        }
    }
}
