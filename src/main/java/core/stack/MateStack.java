package core.stack;

import java.util.EmptyStackException;

public class MateStack<T> {
    private static final int ARR_SIZE = 10;
    private static final int SIZE_MULTIPLIER = 3 / 2;
    private int size;
    private T[] array;

    public MateStack() {
        array = (T[]) new Object[ARR_SIZE];
    }

    public void push(T value) {
        if (size == array.length) {
            array = grow();
        }
        array[size++] = value;
    }

    public T peek() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        return array[size - 1];
    }

    public T pop() {
        T oldValue = peek();
        array[--size] = null;
        return oldValue;
    }

    public int size() {
        return size;
    }

    private int newCapacity() {
        return size * SIZE_MULTIPLIER;
    }

    private T[] grow() {
        T[] grownArray = (T[]) new Object[newCapacity()];
        System.arraycopy(array, 0, grownArray, 0, size);
        return grownArray;
    }
}
