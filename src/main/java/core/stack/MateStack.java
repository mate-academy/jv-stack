package core.stack;

import java.util.EmptyStackException;

public class MateStack<T> {
    private Element<T> topOfStack;
    private int size;

    private static class Element<T> {
        private Element<T> prev;
        private T value;

        public Element(Element<T> prev, T value) {
            this.prev = prev;
            this.value = value;
        }
    }

    public void push(T value) {

        if (size == 0) {
            topOfStack = new Element<>(null, value);
        } else {
            Element<T> oldTopValue = topOfStack;
            topOfStack = new Element<>(oldTopValue, value);
        }
        size++;
    }

    public T peek() {
        sizeCheck();
        return topOfStack.value;

    }

    public T pop() {
        sizeCheck();
        Element<T> oldTopValue = topOfStack;
        topOfStack = oldTopValue.prev;
        size--;
        return oldTopValue.value;
    }

    public int size() {
        return size;
    }

    private void sizeCheck() {
        if (size == 0) {
            throw new EmptyStackException();
        }
    }
}
