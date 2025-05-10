package core.stack;

import java.util.EmptyStackException;

public class MateStack<T> {
    private static final int INITIAL_SIZE_CAPACITY = 10;
    private static final int ADDING_SIZE = 5;
    private T[] array;
    private int size;

    public MateStack() {
        array = (T[]) new Object[INITIAL_SIZE_CAPACITY];
        size = 0;
    }

    public void push(T value) {
        if (size == array.length) {
            grow(array);
        }
        array[size] = value;
        size++;
    }

    public T peek() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        return array[size - 1];
    }

    public T pop() {
        T value = peek();
        array[size - 1] = null;
        size--;
        return value;
    }

    public int size() {
        return size;
    }

    private void grow(T[] arrayValues) {
        T[] temporaryArray = arrayValues;
        arrayValues = (T[]) new Object[arrayValues.length + ADDING_SIZE];
        System.arraycopy(temporaryArray, 0, arrayValues, 0, temporaryArray.length);
    }
}
