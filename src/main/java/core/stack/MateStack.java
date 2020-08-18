package core.stack;

public class MateStack<T> {
    private Node<T> last;
    private int size;

    public MateStack() {
        last = new Node<>(null, null);
    }

    public void push(T value) {
        Node<T> node = last;
        last = new Node<>(value, node);
        size++;
    }

    public T peek() {
        if (size == 0) {
            throw new IndexOutOfBoundsException("Stack is empty");
        }
        return last.element;
    }

    public T pop() {
        if (size == 0) {
            throw new IndexOutOfBoundsException("Stack is empty");
        }
        T removeNode = last.element;
        last = last.next;
        size--;
        return removeNode;
    }

    public int size() {
        return size;
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
