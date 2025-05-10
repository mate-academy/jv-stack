package core.stack;

import java.util.EmptyStackException;

public class MateStack<T> {
    private static final int INITIAL_CAPACITY = 10;
    private static final float MULTIPLIER = 1.5F;
    private T[] elements;
    private int size;

    public MateStack() {
        this.elements = (T[]) new Object[INITIAL_CAPACITY];
    }

    public void push(T value) {
        if (size == elements.length) {
            extendArray();
        }
        elements[size++] = value;
    }

    public T peek() {
        throwEmptyStackException();
        return elements[size - 1];
    }

    public T pop() {
        throwEmptyStackException();
        T current = elements[--size];
        elements[size] = null;
        return current;
    }

    public int size() {
        return size;
    }

    private void extendArray() {
        int newCapacity = (int) (elements.length * MULTIPLIER);
        T[] extendedArray = (T[]) new Object[newCapacity];
        System.arraycopy(elements, 0, extendedArray, 0, size);
        elements = extendedArray;
    }

    private void throwEmptyStackException() {
        if (size == 0) {
            throw new EmptyStackException();
        }
    }
}
