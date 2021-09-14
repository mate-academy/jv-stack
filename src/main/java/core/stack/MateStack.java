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
        if (head == null) {
            throw new EmptyStackException();
        }
        return head.item;
    }

    public T pop() {
        if (head == null) {
            throw new EmptyStackException();
        }
        T itemNew = head.item;
        head = head.next;
        size--;
        return itemNew;
    }

    public int size() {
        return size;
    }

    private static class Node<T> {
        private T item;
        private Node<T> next;

        public Node(T item, Node<T> next) {
            this.item = item;
            this.next = next;
        }
    }

}
