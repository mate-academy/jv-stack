package core.stack;

import java.util.EmptyStackException;

public class MateStack<T> {
    private static final int INITIAL_CAPACITY = 10;
    private Object[] elements;
    private int size = 0;

    public MateStack() {
        elements = new Object[INITIAL_CAPACITY];
    }

    public void push(T value) {
        ensureCapacity();
        elements[size] = value;
        size++;
    }

    public T peek() {
        checkIfEmpty();
        return (T) elements[size - 1];
    }

    public T pop() {
        checkIfEmpty();

        T foundElement = (T) elements[size - 1];
        elements[size - 1] = null;
        size--;
        return foundElement;
    }

    public int size() {
        return size;
    }

    private void ensureCapacity() {
        if (size == elements.length) {
            Object[] newArray = new Object[elements.length * 2];

            for (int i = 0; i < elements.length; i++) {
                newArray[i] = elements[i];
            }
            elements = newArray;
        }
    }

    private void checkIfEmpty() {
        if (size == 0) {
            throw new EmptyStackException();
        }
    }
}
