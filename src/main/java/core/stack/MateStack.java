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
        return last.item;
    }

    public T pop() {
        checkSize();
        final T result = last.item;
        last = last.previous;
        size--;
        return result;
    }

    public int size() {
        return size;
    }

    private static class Node<T> {
        private T item;
        private Node<T> previous;

        public Node(T item, Node<T> previous) {
            this.item = item;
            this.previous = previous;
        }
    }

    private void checkSize() {
        if (size == 0) {
            throw new EmptyStackException();
        }
    }
}
