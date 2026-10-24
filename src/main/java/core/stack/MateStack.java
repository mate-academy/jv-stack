package core.stack;

import java.util.EmptyStackException;

public class MateStack<T> {
    private static final int DEFAULT_CAPACITY = 16;
    private static final int GROW_FACTOR = 2;
    private Object[] elements;
    private int size;

    public MateStack(int capacity) {
        elements = new Object[capacity];
    }

    public MateStack() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public void push(T value) {
        if (size == elements.length) {
            grow();
        }
        elements[size] = value;
        size++;
    }

    public T peek() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        final T removed;
        return removed = (T) elements[size - 1];
    }

    public T pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        final T removed;
        removed = (T) elements[size - 1];
        size--;
        elements[size] = null;
        return removed;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void grow() {
        T[] temp = (T[]) new Object[(elements.length * GROW_FACTOR)];
        System.arraycopy(elements, 0, temp, 0, elements.length);
        elements = temp;
    }
}
