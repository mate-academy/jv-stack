package core.stack;

import java.util.EmptyStackException;

public class MateStack<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private static final int MULTIPLIER = 2;
    private Object[] data;
    private int capacity;
    private int size;

    public MateStack() {
        data = new Object[DEFAULT_CAPACITY];
        capacity = this.data.length;
    }

    public void push(T value) {
        if (size >= capacity) {
            data = grow();
        }
        data[size++] = value;
    }

    private Object[] grow() {
        capacity = capacity * MULTIPLIER;
        Object[] newData = new Object[capacity];
        System.arraycopy(data, 0, newData, 0, data.length);
        return newData;
    }

    public T peek() {
        checkEmptyStackException();
        return (T) data[size - 1];
    }

    public T pop() {
        checkEmptyStackException();
        T lastElement = (T) data[size - 1];
        data[--size] = null;
        return lastElement;
    }

    public int size() {
        return size;
    }

    private void checkEmptyStackException() {
        if (size == 0) {
            throw new EmptyStackException();
        }
    }
}
