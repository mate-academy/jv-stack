package core.stack;

import java.util.EmptyStackException;

public class MateStack<T> {
    private Element<T> top;
    private int size = 0;

    private static class Element<T> {
        private T value;
        private Element<T> previous;

        public Element(T value, Element<T> previous) {
            this.value = value;
            this.previous = previous;
        }
    }

    public void push(T value) {
        if (size == 0) {
            top = new Element<>(value, null);
        } else {
            Element<T> notTheTopAnyMore = top;
            top = new Element<>(value, notTheTopAnyMore);
        }
        size++;
    }

    public T peek() {
        if (size == 0) {
            throw new EmptyStackException();
        } else {
            return top.value;
        }
    }

    public T pop() {
        if (size == 0) {
            throw new EmptyStackException();
        } else {
            Element<T> notTheTopAnyMore = top;
            top = notTheTopAnyMore.previous;
            size--;
            return notTheTopAnyMore.value;
        }
    }

    public int size() {
        return size;
    }
}
