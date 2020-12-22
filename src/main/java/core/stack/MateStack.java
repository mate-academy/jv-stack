package core.stack;

import java.util.EmptyStackException;

public class MateStack<T> {
    private static final int INITIAL_CAPACITY = 10;
    private static final int CAPACITY_MULTIPLY = 2;
    private T[] array;
    private int capacity;

    public MateStack() {
        array = (T[]) new Object[INITIAL_CAPACITY];
    }

    public void push(T value) {
        if (capacity == array.length) {
            resize();
        }
        array[capacity] = value;
        capacity++;
    }

    private void resize() {
        T[] newArray = (T[]) new Object[capacity * CAPACITY_MULTIPLY];
        System.arraycopy(array, 0, newArray, 0, array.length);
        array = newArray;
    }

    public T peek() {
        checkCapacity();
        return array[capacity - 1];
    }

    public T pop() {
        checkCapacity();
        T value = array[capacity - 1];
        array[capacity - 1] = null;
        capacity--;
        return value;
    }

    private void checkCapacity() {
        if (capacity == 0) {
            throw new EmptyStackException();
        }
    }

    public int size() {
        return capacity;
    }
}
