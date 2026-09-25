package core.stack;

import java.util.EmptyStackException;

public class MateStack<T> {

    private Node<T> stackHead;
    private int size;

    public void push(T value) {
        Node<T> newNode = new Node(value, this.stackHead);

        this.stackHead = newNode;
        this.size++;
    }

    public T peek() {
        if (this.stackHead == null) {
            throw new EmptyStackException();
        }
        return this.stackHead.getValue();
    }

    public T pop() {
        if (this.stackHead == null) {
            throw new EmptyStackException();
        }
        Node<T> nextNode = this.stackHead.getNext();
        T value = this.stackHead.getValue();
        this.stackHead = nextNode;
        this.size--;
        return value;
    }

    public int size() {
        return this.size;
    }

    private class Node<T> {

        private T value;
        private Node<T> next;

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }

        public T getValue() {
            return this.value;
        }

        public Node<T> getNext() {
            return this.next;
        }
    }
}
