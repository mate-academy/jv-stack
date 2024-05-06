package core.stack;

import java.util.EmptyStackException;

public class MateStack<T> {
    private static final int DEFAULT_ARRAY_LENGTH = 10;
    private static final int GROW_FACTOR = 2;
    private int size;
    private T[] array;

    public MateStack() {
        array = (T[]) new Object[DEFAULT_ARRAY_LENGTH];
        size = 0;
    }

    public void push(T value) {
        if (array.length == size) {
            grow();
        }
        ++size;
        array[size] = value;

    }

    private void grow() {
        int newLength = size * GROW_FACTOR;
        T[] newArray = (T[]) new Object[newLength];
        System.arraycopy(array, 0, newArray, 0, size);
        array = newArray;
    }

    public T peek() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        return array[size];
    }

    public T pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        T returnElement = array[size];
        array[size] = null;
        size--;
        return returnElement;
    }

    public int size() {
        return size;
    }
}
