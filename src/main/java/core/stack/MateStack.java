package core.stack;

import java.util.EmptyStackException;

public class MateStack<T> {
    private static final int DEF_CAPACITY = 10;
    private static final int GROW_FACTOR = 2;
    private T[] array;
    private int size;

    public MateStack() {
        array = (T[]) new Object[DEF_CAPACITY];
    }

    public void push(T value) {
        checkCapacity();
        array[size++] = value;
    }

    public T peek() {
        checkNotEmpty();
        return array[size - 1];
    }

    public T pop() {
        checkNotEmpty();
        T current = array[--size];
        array[size] = null;
        return current;
    }

    public int size() {
        return size;
    }

    private boolean isEmpty() {
        return size == 0;
    }

    private void checkCapacity() {
        if (size == array.length) {
            int newSize = array.length * GROW_FACTOR;
            T[] newArray = (T[]) new Object[newSize];
            System.arraycopy(array, 0, newArray, 0, size);
            array = newArray;
        }
    }

    private void checkNotEmpty() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
    }
}