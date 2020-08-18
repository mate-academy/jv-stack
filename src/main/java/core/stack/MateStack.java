package core.stack;

public class MateStack<T> {
    private Node<T> first;
    private int size;

    public void push(T value) {
        Node<T> node;
        if (first == null) {
            node = new Node<>(value);
            first = node;
        } else {
            node = new Node<>(value, first);
            first = node;
        }
        size++;
    }

    public T peek() {
        if (size == 0) {
            throw new IndexOutOfBoundsException("Stack is empty");
        }
        return first.value;
    }

    public T pop() {
        if (size == 0) {
            throw new IndexOutOfBoundsException("Stack is empty");
        }
        T poppedValue = first.value;
        first = first.next;
        size--;
        return poppedValue;
    }

    public int size() {
        return size;
    }

    private class Node<T> {
        private T value;
        private Node<T> next;

        Node(T value) {
            this.value = value;
        }

        Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }
}
