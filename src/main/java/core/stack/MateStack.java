package core.stack;

import java.util.EmptyStackException;

public class MateStack<T> {
    private static final int INITIAL_CAPACITY = 10;
    private static final float MULTIPLIER = 1.5f;

    private T[] data;
    private int size;

    public MateStack() {
        data = (T[]) new Object[INITIAL_CAPACITY];
    }

    public void push(T value) {
        if (size == data.length) {
            resize();
        }
        data[size] = value;
        size++;
    }

    public T peek() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        return data[size - 1];
    }

    public T pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        final T element = data[size - 1];
        data[--size] = null;
        return element;
    }

    public int size() {
        return size;
    }

    private void resize() {
        T[] newArray = (T[]) new Object[(int)(data.length * MULTIPLIER)];
        System.arraycopy(data, 0, newArray, 0, size);
        data = newArray;
    }
}
