package core.stack;

import java.util.EmptyStackException;

public class MateStack<T> {
    private Node<T> head;
    private int size;

    public void push(T value) {
        if (head == null) {
            head = new Node<>(null, value);
        } else {
            Node<T> current = head;
            while (true) {
                if (current.next == null) {
                    current.next = new Node<>(null, value);
                    break;
                }
                current = current.next;
            }
        }
        size++;
    }

    public T peek() {
        sizeChecker(size);
        Node<T> current = head;
        while (true) {
            if (current.next == null) {
                return current.item;
            }
            current = current.next;
        }
    }

    public T pop() {
        sizeChecker(size);
        T retValue;
        Node<T> last = head;
        while (true) {
            if (size > 2 && last.next.next == null) {
                retValue = last.next.item;
                last.next = null;
                size--;
                break;
            } else if (size == 2) {
                retValue = head.next.item;
                head.next = null;
                size--;
                break;
            } else if (size == 1) {
                retValue = head.item;
                head = null;
                size--;
                break;
            }
            last = head.next;
        }
        return retValue;
    }

    public int size() {
        return size;
    }

    private void sizeChecker(int size) {
        if (size == 0) {
            throw new EmptyStackException();
        }
    }

    private static class Node<T> {
        Node<T> next;
        T item;

        public Node(Node<T> next, T value) {
            this.next = next;
            this.item = value;
        }
    }
}
