package core.stack;

import java.util.EmptyStackException;

public class MateStack<T> {
    private int size;
    private Node<T> last;
    private Node<T> first;

    private static class Node<T> {
        private final T value;
        private Node<T> next;

        private Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }

    public void push(T value) {
        Node<T> nextNode = new Node<>(value, null);
        if (size == 0) {
            first = last = nextNode;
        } else {
            if (first.next == null) {
                first.next = nextNode;
            }
            last.next = nextNode;
            last = last.next;
        }
        size++;
    }

    public T peek() {
        if (last == null) {
            throw new EmptyStackException();
        }
        return last.value;
    }

    public T pop() {
        if (last == null) {
            throw new EmptyStackException();
        }
        final Node<T> temp = last;
        Node<T> iterator = first;
        while (iterator.next != last && last != first) {
            iterator = iterator.next;
        }
        last = iterator;
        size--;
        return temp.value;
    }

    public int size() {
        return size;
    }
}
