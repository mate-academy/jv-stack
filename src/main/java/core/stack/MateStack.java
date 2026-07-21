package core.stack;

import java.util.EmptyStackException;

public class MateStack<T> {
    int size = 0;
    Node head;

    public MateStack() {
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
        T value;
        Node next;

        public Node(T value) {
            this.value = value;
            this.next = null;
        }
    }
}
