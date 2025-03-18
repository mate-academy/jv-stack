package core.stack;

import java.util.EmptyStackException;

public class MateStack<T> {
    private static final int DEF_CAPACITY = 10;
    private Object[] array;
    private int size;

    public MateStack() {
        array = new Object[DEF_CAPACITY];
        size = 0;
    }

    public void push(T value) {
        checkCapacity();
        array[size++] = value;
    }

    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return (T) array[size - 1];
    }

    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        T current = (T) array[--size];
        array[size] = null;
        return current;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void checkCapacity() {
        if (size == array.length) {
            int newSize = array.length * 2;
            Object[] newArray = new Object[newSize];
            System.arraycopy(array, 0, newArray, 0, size);
            array = newArray;
        }
    }
}