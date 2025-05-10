package core.stack;

import java.util.EmptyStackException;

public class MateStack<T> {
    private Node<T> last;
    private int size;

    public void push(T value) {
        last = new Node<>(value, last);
        size++;
    }

    public T peek() {
        checkSize();
        return last.value;
    }

    public T pop() {
        T deletedValue = peek();
        last = last.previous;
        size--;
        return deletedValue;
    }

    public int size() {
        return size;
    }

    private void checkSize() {
        if (size == 0) {
            throw new EmptyStackException();
        }
    }

    private static class Node<T> {
        private T value;
        private Node<T> previous;

        public Node(T value, Node<T> previous) {
            this.value = value;
            this.previous = previous;
        }
    }
}
