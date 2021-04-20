package core.stack;

import java.util.EmptyStackException;

public class MateStack<T> {
    private static final int DEFAULT_ARRAY_CAPACITY = 10;
    private int size;
    private T[] dataArray = (T[]) new Object[DEFAULT_ARRAY_CAPACITY];

    public void push(T value) {
        grow();
        dataArray[size++] = value;
    }

    public T peek() {
        checkArrayIsEmpty();
        return dataArray[size - 1];
    }

    public T pop() {
        checkArrayIsEmpty();
        T value = dataArray[size - 1];
        dataArray[size - 1] = null;
        size--;
        return value;
    }

    public int size() {
        return size;
    }

    private void checkArrayIsEmpty() {
        if (size == 0) {
            throw new EmptyStackException();
        }
    }

    private void grow() {
        if (size == dataArray.length) {
            T[] array = (T[]) new Object[size + (size >> 1)];
            System.arraycopy(dataArray, 0, array, 0, size);
            dataArray = array;
        }
    }
}
