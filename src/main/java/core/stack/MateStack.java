package core.stack;

import java.util.EmptyStackException;

public class MateStack<T> {

    private Node<T> tail;
    private int size;

    static class Node<T> {
        private T value;
        private Node<T> prev;
        private Node<T> next;

        public Node(Node<T> prev, T value, Node<T> next) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }

    public void push(T value) {

        Node<T> last = tail;
        tail = new Node<>(last, value, null);
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
        Node<T> newTail = tail.prev;
        Node<T> tailCopy = tail;
        if (tail.prev == null) {
            newTail = tail;
        }
        if (size >= 0) {
            tail = newTail;
            tail.next = null;
            size--;
            return tailCopy.value;
        }
        return null;
    }

    public int size() {
        return size;
    }
}

