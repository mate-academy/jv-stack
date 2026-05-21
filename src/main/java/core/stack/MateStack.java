package core.stack;

import java.util.EmptyStackException;

public class MateStack<T> {

    private Node front = null;
    private int size = 0;

    public void push(T value) {
        Node node = new Node(value);
        node.prev = front;
        front = node;
        size++;
    }

    public T peek() {
        if (front == null) {
            throw new EmptyStackException();
        }
        return front.value;
    }

    public T pop() {
        if (front == null) {
            throw new EmptyStackException();
        }
        Node temp = front;
        front = front.prev;
        size--;
        return temp.value;
    }

    public int size() {
        return size;
    }

    private class Node {
        private T value;
        private Node prev;

        public Node(T value) {
            this.value = value;
        }
    }
}
