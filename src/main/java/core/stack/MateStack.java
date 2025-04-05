package core.stack;

import java.util.EmptyStackException;

public class MateStack<T> {

    private Node<T> head;
    private int size = 0;

    public void push(T value) {
        Node<T> node = new Node<>(value, head);
        head = node;
        size++;
    }

    public T peek() {
        if (head == null) {
            throw new EmptyStackException();
        }
        T value = head.value;
        return value;
    }

    public T pop() {
        if (head == null) {
            throw new EmptyStackException();
        }
        T value = head.value;
        head = head.prev;
        size--;
        return value;
    }

    public int size() {
        return size;
    }

    private static class Node<T> {
       private T value;
       private Node<T> prev;

        public Node(T value, Node<T> prev) {
            this.value = value;
            this.prev = prev;
        }
    }
}
