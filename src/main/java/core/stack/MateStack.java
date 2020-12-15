package core.stack;

public class MateStack<T> {
    private static final int DEFAULT_SIZE = 10;
    private Node<T>[] stack;
    private Node<T> top;
    private int size;

    public MateStack() {
        this.stack = (Node<T>[]) new Node[DEFAULT_SIZE];
    }

    public void push(T value) {

    }

    public T peek() {
        return null;
    }

    public T pop() {
        return null;
    }

    public int size() {
        return 0;
    }

    private static class Node<T> {
        private T value;
        private Node<T> next;

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }
}
