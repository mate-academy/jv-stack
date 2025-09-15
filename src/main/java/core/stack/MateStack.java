package core.stack;

import java.util.EmptyStackException;

public class MateStack<T> {
    private Node<T> head;
    private int size;

    public void push(T value) {
        head = new Node<>(value,head);
        size++;
    }

    public T peek() {
        if (head == null) {
            throw new EmptyStackException();
        }
        return head.element;
    }

    public T pop() {
        if (head == null) {
            throw new EmptyStackException();
        }
        Node<T> temp = head;
        head = head.next;
        size--;
        temp.next = null;
        T result = temp.element;
        temp.element = null;
        return result;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private static class Node<T> {
        private T element;
        private Node<T> next;

        public Node(T element, Node<T> next) {
            this.element = element;
            this.next = next;
        }
    }
}
