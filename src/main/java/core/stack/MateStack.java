package core.stack;

import java.util.EmptyStackException;

public class MateStack<T> {
    private Node head;
    private int size = 0;

    public MateStack() {
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void push(T value) {
        Node newNode = new Node(value);
        newNode.next = head;
        size++;
        head = newNode;
    }

    public T peek() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        return head.value;
    }

    public T pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        Node response = head;
        head = head.next;
        size--;
        return response.value;
    }

    public int size() {
        return size;
    }

    public class Node {
        private T value;
        private Node next;

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node(T value) {
            this.value = value;
            this.next = null;
        }
    }
}
