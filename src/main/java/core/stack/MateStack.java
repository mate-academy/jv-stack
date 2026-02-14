package core.stack;

import java.util.EmptyStackException;

public class MateStack<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] elements;
    private int size;

    public MateStack() {
        elements = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    public void push(T value) {
        if (size == elements.length) {
            resize();
        }
        elements[size++] = value;
    }

    public T peek() {
        if (size == 0) {
            throw new EmptyStackException();
        }

        return (T) elements[size - 1];
    }

    public T pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }

        T value = (T) elements[--size];

        elements[size] = null;

        return value;
    }

    public int size() {
        return size;
    }

    private void resize() {
        Object[] newElements = new Object[elements.length * 2];

        for (int i = 0; i < elements.length; i++) {
            newElements[i] = elements[i];
        }

        elements = newElements;
    }
}
