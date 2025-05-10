package core.stack;

import java.util.EmptyStackException;

public class MateStack<T> {
    private static final int INITIAL_ARRAY_SIZE = 10;
    private static final double COEFFICIENT_INCREASE_ARRAY = 1.5;
    private T[] array;
    private int size;

    public MateStack() {
        array = (T[]) new Object[INITIAL_ARRAY_SIZE];
    }

    public void push(T value) {
        array[size++] = value;
        if (size == array.length) {
            growArray();
        }
    }

    public T peek() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        return array[size - 1];
    }

    public T pop() {
        T removed = peek();
        array[--size] = null;
        return removed;
    }

    public int size() {
        return size;
    }

    private void growArray() {
        T[] newArray = (T[]) new Object[(int) (array.length * COEFFICIENT_INCREASE_ARRAY)];
        System.arraycopy(array, 0, newArray, 0, size);
        array = newArray;
    }
}
