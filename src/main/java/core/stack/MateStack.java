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
        return last.element;
    }

    public T pop() {
        checkSize();
        T deletedValue = last.element;
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
        private T element;
        private Node<T> previous;

        public Node(T element, Node<T> next) {
            this.element = element;
            this.previous = next;
        }
    }
}
