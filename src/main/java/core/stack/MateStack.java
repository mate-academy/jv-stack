package core.stack;

public class MateStack<T> {
    private int size;
    private Node<T> first;

    public MateStack() {
        this.size = size = 0;
        this.first = null;
    }

    public void push(T value) {
        Node<T> newNode = new Node<>(value, null);
        if (first == null) {
            first = newNode;
            size++;
            return;
        }
        newNode.next = first;
        first = newNode;
        size++;
    }

    public T peek() {
        if (first == null) {
            throw new IndexOutOfBoundsException("Stack is empty");
        }
        return first.value;
    }

    public T pop() {
        if (first == null) {
            throw new IndexOutOfBoundsException("Stack is empty");
        }
        Node<T> result = first;
        first = first.next;
        size--;
        return result.value;
    }

    public int size() {
        return size;
    }

    private static class Node<T> {
        private T value;
        private Node<T> next;
        private Node<T> previous;

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;

        }
    }
}


