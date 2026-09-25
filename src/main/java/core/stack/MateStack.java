package core.stack;

import java.util.EmptyStackException;

public class MateStack<T> {

    private Node<T> stackHead;
    private int size;

    public void push(T value) {
        this.stackHead = new Node<>(value, this.stackHead);
        this.size++;
    }

    public T peek() {
        if (this.stackHead == null) {
            throw new EmptyStackException();
        }
        return this.stackHead.value;
    }

    public T pop() {
        if (this.stackHead == null) {
            throw new EmptyStackException();
        }
        T value = this.stackHead.value;
        this.stackHead = this.stackHead.next;
        this.size--;
        return value;
    }

    public int size() {
        return this.size;
    }

    private static class Node<T> {

        private T value;
        private Node<T> next;

        private Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }
}
