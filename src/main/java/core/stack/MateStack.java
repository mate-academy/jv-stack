package core.stack;

public class MateStack<T> {
    private int size;
    private Node<T> head;

    public MateStack() {
        this.size = 0;
        this.head = null;
    }

    public void push(T value) {
        Node<T> tmp = head;

        if (size == 0) {
            head = new Node<>(value, null);
        } else {
            head = new Node<>(value, tmp);
        }
        size++;

    }

    public T peek() {
        checkSize();
        return head.value;
    }

    public T pop() {
        checkSize();
        Node<T> tmp = head;
        T result = tmp.value;

        if (size == 1) {
            tmp = null;
            size--;
            return result;
        }
        head = tmp.next;
        tmp = null;
        size--;

        return result;
    }

    public int size() {
        return size;
    }

    private void checkSize() {
        if (size == 0) {
            throw new IndexOutOfBoundsException("Stack is empty");
        }
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
