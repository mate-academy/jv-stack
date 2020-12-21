package core.stack;

import java.util.EmptyStackException;

public class MateStack<T> {
    private int size;
    private Node<T> current;

    public void push(T value) {
        current = new Node<>(current, value);
        ++size;
    }

    public T peek() {
        validateSize();
        return current.value;
    }

    public T pop() {
        validateSize();
        T value = current.value;
        current = current.prev;
        --size;
        return value;
    }

    private void validateSize() {
        if (size == 0) {
            throw new EmptyStackException();
        }
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
