package core.stack;

import java.util.EmptyStackException;

public class MateStack<T> {
    private static final int INITIAL_CAPACITY = 10;
    private static final double SHRINK_THRESHOLD = 0.25;
    private T[] elements;
    private int size;

    @SuppressWarnings("unchecked")
    public MateStack() {
        elements = (T[]) new Object[INITIAL_CAPACITY];
        size = 0;
    }

    public void push(T value) {
        ensureCapacity();
        addValue(value);
    }

    public T peek() {
        ensureNotEmpty();
        return elements[size - 1];
    }

    public T pop() {
        ensureNotEmpty();
        return removeValue();
    }

    public int size() {
        return size;
    }

    @SuppressWarnings("unchecked")
    private void resize() {
        T[] newArray = (T[]) new Object[elements.length * 2];
        System.arraycopy(elements, 0, newArray, 0, elements.length);
        elements = newArray;
    }

    private void shrink() {
        if (size < elements.length * SHRINK_THRESHOLD && elements.length > INITIAL_CAPACITY) {
            T[] newArray = (T[]) new Object[elements.length / 2];
            System.arraycopy(elements, 0, newArray, 0, size);
            elements = newArray;
        }
    }

    private void ensureNotEmpty() {
        if (size == 0) {
            throw new EmptyStackException();
        }
    }

    private void ensureCapacity() {
        if (size == elements.length) {
            resize();
        }
    }

    private void addValue(T value) {
        elements[size++] = value;
    }

    private T removeValue() {
        T value = elements[--size];
        elements[size] = null;
        shrink();
        return value;
    }
}
