package core.stack;

import java.util.EmptyStackException;

public class MateStack<T> {
    private static final int ARRAY_SIZE = 10;
    private static final int FIRST_INDEX = 0;
    private static final int DECREMENT = 1;
    private static final double COEFFICIENT_INCREASE_ARRAY = 1.5;
    private T[] array;
    private int size;

    public MateStack() {
        array = (T[]) new Object[ARRAY_SIZE];
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
        return array[size - DECREMENT];
    }

    public T pop() {
        T removed;
        removed = peek();
        array[--size] = null;
        return removed;
    }

    public int size() {
        return size;
    }

    private void growArray() {
        T[] newArray = (T[]) new Object[(int) (array.length * COEFFICIENT_INCREASE_ARRAY)];
        System.arraycopy(array, FIRST_INDEX, newArray, FIRST_INDEX, size);
        array = newArray;
    }
}
