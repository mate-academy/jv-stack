package core.stack;

import java.util.EmptyStackException;

public class MateStack<T> {
    private Node<T> head;
    private int size;

    public void push(T value) {
        if (head == null) {
            head = new Node<>(value, null);
        }
        head = new Node<>(value, head);
        size++;
    }

    public T peek() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        return head.elementValue;
    }

    public T pop() {
        T headValue = peek();
        head = head.next;
        size--;
        return headValue;
    }

    public int size() {
        return size;
    }

    private class Node<T> {
        private T elementValue;
        private Node<T> next;

        public Node(T elementValue, Node<T> next) {
            this.elementValue = elementValue;
            this.next = next;
        }
    }
}
