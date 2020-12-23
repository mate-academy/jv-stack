package core.stack;

import java.util.EmptyStackException;

public class MateStack<T> {
    private MyNode<T> first;
    private int size;

    public void push(T value) {
        MyNode<T> currentNode = new MyNode<>(value, first);
        if (size == 0) {
            currentNode.next = null;
        }
        first = currentNode;
        size++;
    }

    public T peek() {
        checkStack();
        return first.value;
    }

    public T pop() {
        checkStack();
        T currentNodeValue = first.value;
        first = first.next;
        size--;
        return currentNodeValue;
    }

    public int size() {
        return size;
    }

    private void checkStack() {
        if (size == 0) {
            throw new EmptyStackException();
        }
    }

    private static class MyNode<T> {
        private T value;
        private MyNode<T> next;

        MyNode(T value, MyNode<T> next) {
            this.value = value;
            this.next = next;
        }
    }
}
