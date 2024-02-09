package core.stack;

import java.util.EmptyStackException;

@SuppressWarnings("unchecked")
public class MateStack<T> {
    private static final int DEFAULT_SIZE = 10;
    private static final double RESIZE_FACTOR = 1.5;

    private T[] data;
    private int size;

    public MateStack() {
        this.data = (T[]) new Object[DEFAULT_SIZE];
    }

    public void push(T value) {
        growIfArrayFull();
        data[size++] = value;
    }

    public T peek() {
        if (size > 0) {
            return data[size - 1];
        }

        throw new EmptyStackException();
    }

    public T pop() {
        if (size > 0) {
            T valueDeleted = data[--size];
            data[size] = null;
            return valueDeleted;
        }

        throw new EmptyStackException();
    }

    public int size() {
        return size;
    }

    private void growIfArrayFull() {
        if (size == data.length) {
            grow();
        }
    }

    private void grow() {
        int resizedCapacity = (int) (data.length * RESIZE_FACTOR);
        T[] tempCopyOfArray = (T[]) new Object[resizedCapacity];
        System.arraycopy(data, 0, tempCopyOfArray, 0, data.length);
        data = (T[]) new Object[resizedCapacity];
        System.arraycopy(tempCopyOfArray, 0, data, 0, data.length);
    }
}
