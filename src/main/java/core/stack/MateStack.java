package core.stack;

import  java.util.EmptyStackException;

public class MateStack<T> {
    private int size;
    private Node<T> top;

    public void push(T value) {
      top = new Node<>(value,top);
      size++;
    }

    public T peek() {
        checkSize();
        return top.value;
    }

    public T pop() {
        checkSize();
        T removedValue = top.value;
        top = top.next;
        size--;
        return removedValue;
    }

    public int size() {
        return size;
    }

    private static  class Node<T> {
        private T value;
        private Node<T> next;

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }

    private void checkSize() {
        if (size == 0) {
            throw new EmptyStackException();
        }
    }
}
