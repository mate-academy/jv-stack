package core.stack;

import java.util.EmptyStackException;

public class MateStack<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private T[] array;
    private int size;

    public MateStack() {
        array = (T[]) new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    public void push(T value) {
        if (size == array.length) {
            grow();
        }
        array[size] = value;
        size++;
    }

    public T peek() {
        checkException();
        return array[size - 1];
    }

    public T pop() {
        checkException();
        T element = array[size - 1];
        array[size - 1] = null;
        size--;
        return element;
    }

    public int size() {
        return size;
    }

    private void grow() {
        Object[] newArray = new Object[array.length + (array.length >> 1)];
        System.arraycopy(array, 0, newArray, 0, array.length);
        array = (T[]) newArray;
    }

    private void checkException() {
        if (size == 0) {
            throw new EmptyStackException();
        }
    }
}
