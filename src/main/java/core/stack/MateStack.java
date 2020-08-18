package core.stack;

public class MateStack<T> {
    private Node<T> lastNode;
    private int size;

    public MateStack() {
        lastNode = new Node<>(null, null);
    }

    public void push(T value) {
        Node<T> lowerNode = lastNode;
        lastNode = new Node<>(value, lowerNode);
        size++;
    }

    public T peek() {
        checkTable();
        return lastNode.value;
    }

    public T pop() {
        checkTable();
        T element = lastNode.value;
        lastNode = lastNode.lowerNode;
        size--;
        return element;
    }

    public int size() {
        return size;
    }

    private void checkTable() {
        if (size == 0) {
            throw new IndexOutOfBoundsException("Stack is empty");
        }
    }

    private static class Node<T> {
        public T value;
        public Node<T> lowerNode;

        public Node(T value, Node<T> lowerNode) {
            this.value = value;
            this.lowerNode = lowerNode;
        }
    }
}
