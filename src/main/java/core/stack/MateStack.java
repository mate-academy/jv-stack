package core.stack;

import java.util.EmptyStackException;

public class MateStack<T> {
    public static final int DEFAULT_CAPACITY = 10;
    public static final int MULTIPLIER = 2;
    private Object[] data;
    private int capacity;
    private int size;

    public MateStack() {
        this.data = new Object[DEFAULT_CAPACITY];
        capacity = this.data.length;
    }

    public void push(T value) {
        if (size >= capacity) {
            this.data = grow();
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
        if (size == 0) {
            throw new EmptyStackException();
        }
        return (T) data[size - 1];
    }

    public T pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        T lastElement = (T) data[size - 1];
        data[--size] = null;
        return lastElement;
    }

    public int size() {
        return size;
    }
}
