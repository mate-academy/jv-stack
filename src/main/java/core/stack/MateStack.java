package core.stack;

public class MateStack<T> {
    private Node<T> topNode;
    private Node<T> bottomNode;
    private int size;

    public MateStack() {
        size = 0;
    }

    public void push(T value) {
        if (size == 0) {
            topNode = new Node<T>(null, value);
            bottomNode = new Node<T>(null, value);
        } else {
            Node<T> currentNode = topNode;
            while (currentNode.next != null) {
                currentNode = currentNode.next;
            }
            bottomNode = new Node<>(null, value);
            currentNode.next = bottomNode;
        }
        size++;
    }

    public T peek() {
        isEmptyStack();
        return bottomNode.getElement();
    }

    public T pop() {
        isEmptyStack();
        T popped = bottomNode.getElement();
        topNode = topNode.next;
        size--;
        return popped;
    }

    public int size() {
        return size;
    }

    private void isEmptyStack() {
        if (size == 0) {
            throw new IndexOutOfBoundsException("Stack is empty");
        }
    }

    private static class Node<T> {
        Node<T> next;
        T element;

        public Node(Node<T> next, T element) {
            this.next = next;
            this.element = element;
        }
        public T getElement() {
            return element;
        }
    }
}
