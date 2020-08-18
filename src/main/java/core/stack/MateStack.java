package core.stack;

public class MateStack<T> {

    private Node<T> first = null;
    private int size = 0;

    public void push(T value) {
        addFirst(value);
        size++;
    }

    public T peek() {
        if (size == 0) {
            throw new IndexOutOfBoundsException("Stack is empty");
        }
        return first.data;
    }

    public T pop() {
        if (size == 0) {
            throw new IndexOutOfBoundsException("Stack is empty");
        }
        size--;
        return removeFirst();
    }

    public int size() {
        return size;
    }

    public void addFirst(T data) {
        Node<T> newFirst = new Node<T>(data);
        newFirst.next = first;
        first = newFirst;
    }

    public T removeFirst() {
        Node<T> oldFirst = first;
        first = first.next;
        return oldFirst.data;
    }

    public static class Node<T> {

        private T data;
        private Node<T> next;
        private Node<T> first;

        public Node(T data) {
            this.data = data;
            this.first = null;
        }
    }
}
