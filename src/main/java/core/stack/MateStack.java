package core.stack;

import java.util.EmptyStackException;

public class MateStack<T> {
    private int size;
    private Node<T> current;

    public void push(T value) {
        if (size == 0) {
            current = new Node<>(null, value);
        } else {
            Node<T> current = this.current;
            this.current = new Node<>(current, value);
        }
        ++size;
    }

    public T peek() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        return current.value;
    }

    public T pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        T value = current.value;
        current = current.prev;
        --size;
        return value;
    }

    public int size() {
        return size;
    }

    private static class Node<T> {
        T value;
        Node<T> prev;

        public Node(Node<T> prev, T value) {
            this.value = value;
            this.prev = prev;
        }
    }
}
