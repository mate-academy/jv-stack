package core.stack;

import java.util.EmptyStackException;

public class MateStack<T> {
    private static final int CAPACITY = 10;
    private static final double COEFFICIENT = 0.5;
    private static final int NUMBER_ONE = 1;
    private T[] array;
    private int size;

    public MateStack() {
        array = (T[]) new Object[CAPACITY];
        size = 0;
    }

    public void push(T value) {
        if (size >= array.length) {
            array = resize(array);
        }
        array[size] = value;
        size++;
    }

    public T peek() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        return array[size - NUMBER_ONE];
    }

    public T pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        T currentValue = array[size - NUMBER_ONE];
        size--;
        array[size] = null;
        return currentValue;
    }

    public int size() {
        return size;
    }

    private T[] resize(T[] array) {
        T[] newArray = (T[]) new Object[(int) (array.length * COEFFICIENT + array.length)];
        System.arraycopy(array, 0, newArray, 0, array.length);
        return newArray;
    }
}
