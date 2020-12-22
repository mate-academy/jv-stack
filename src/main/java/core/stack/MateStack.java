package core.stack;

import java.util.EmptyStackException;

public class MateStack<T> {
    private static final int CAPACITY = 10;
    private static final double COEFFICIENT = 0.5;
    private static final int ONE = 1;
    private T[] array;
    private int size;

    public MateStack() {
        array = (T[]) new Object[CAPACITY];
        size = 0;
    }

    public void push(T value) {
        if (size == array.length) {
            resize();
        }
        array[size] = value;
        size++;
    }

    public T peek() {
        isEmptyStack();
        return array[size - ONE];
    }

    public T pop() {
        isEmptyStack();
        T currentValue = array[size - ONE];
        array[size - ONE] = null;
        size--;
        return currentValue;
    }

    public int size() {
        return size;
    }

    private void resize() {
        T[] oldArray = array;
        array = (T[]) new Object[(int) (array.length * COEFFICIENT + array.length)];
        System.arraycopy(array, 0, oldArray, 0, oldArray.length);
    }

    private void isEmptyStack() {
        if (size == 0) {
            throw new EmptyStackException();
        }
    }
}
