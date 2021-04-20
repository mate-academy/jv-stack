package core.stack;

import java.util.EmptyStackException;

public class MateStack<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private int size = 0;
    private T[] elements;

    public MateStack() {
        elements = (T[]) new Object[DEFAULT_CAPACITY];
    }

    public void push(T value) {
        if (size == elements.length) {
            elements = resize();
        }
        elements[size] = value;
        size++;
    }

    public T peek() {
        checkIfIsEmpty();
        return elements[size - 1];
    }

    public T pop() {
        checkIfIsEmpty();
        T popElement = elements[size - 1];
        elements[size - 1] = null;
        size--;
        return popElement;
    }

    public int size() {
        return size;
    }

    private T[] resize() {
        T[] extendedArray = (T[]) new Object[(size * 3) / 2];
        System.arraycopy(elements, 0, extendedArray, 0, size);
        return extendedArray;
    }

    private void checkIfIsEmpty() {
        if (size == 0) {
            throw new EmptyStackException();
        }
    }
}
