package core.stack;

public class MateStack<T> {
    private int size;
    private Node<T> head;
    private Node<T> tail;

    public MateStack() {
        size = 0;
    }

    public void push(T value) {
        Node<T> node = new Node<>(tail, value, null);
        if (size == 0) {
            head = node;
        } else {
            tail.next = node;
        }
        tail = node;
        size++;
    }

    public T peek() {
        if (size <= 0) {
            throw new IndexOutOfBoundsException("Stack is empty");
        }
        return tail.item;
    }

    public T pop() {
        if (size <= 0) {
            throw new IndexOutOfBoundsException("Stack is empty");
        }
        Node<T> node = tail;
        tail = tail.prev;
        size--;
        return node.item;
    }

    public int size() {
        return size;
    }

    private static class Node<T> {
        T item;
        Node<T> next;
        Node<T> prev;

        Node(Node<T> prev, T element, Node<T> next) {
            item = element;
            this.next = next;
            this.prev = prev;
        }
    }
}
