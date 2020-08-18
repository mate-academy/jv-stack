package core.stack;

public class MateStack<T> {

    private int size = 0;
    private Node<T> upperNode;

    public MateStack() {
        upperNode = new Node<>(null, null);
    }

    public void push(T value) {
        Node<T> lowerNode = upperNode;
        upperNode = new Node<>(value, lowerNode);
        size++;
    }

    public T peek() {
        sizeCheck();
        return upperNode.element;
    }

    public T pop() {
        sizeCheck();
        T oldElement = upperNode.element;
        upperNode = upperNode.lowerNode;
        size--;
        return oldElement;
    }

    public int size() {
        return size;
    }

    private void sizeCheck() {
        if (size == 0) {
            throw new IndexOutOfBoundsException("Stack is empty");
        }
    }

    private static class Node<T> {
        public T element;
        public Node<T> lowerNode;

        public Node(T element, Node<T> lowerNode) {
            this.element = element;
            this.lowerNode = lowerNode;
        }
    }
}
