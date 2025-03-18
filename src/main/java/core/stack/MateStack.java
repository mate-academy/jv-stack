package core.stack;

import java.util.Arrays;
import java.util.EmptyStackException;

public class MateStack<T> {
    private static final int DEFAULT_CAPACITY = 8;
    private static final int GROW = 2;
    private int size;
    private Object[] array;

    public MateStack() {
        array = new Object[DEFAULT_CAPACITY];
    }

    @SuppressWarnings("unchecked")
    public T pop() {
        if (size > 0) {
            size--;
            T removedElement = (T) array[size];
            array[size] = null;
            return removedElement;
        } else {
            throw new EmptyStackException();
        }
    }

    @SuppressWarnings("unchecked")
    public T peek() {
        if (size > 0) {
            return (T) array[size - 1];
        } else {
            throw new EmptyStackException();
        }
    }

    public void push(T value) {
        if (size == array.length) {
            ensureCapacity();
        }
        array[size] = value;
        size++;
    }

    @Override
    public String toString() {
        return Arrays.toString(array);

    }

    public int size() {
        return size;
    }

    @SuppressWarnings("unchecked")
    private void ensureCapacity() {
        int newCapacity = array.length * GROW;
        T[] newArray = (T[]) new Object[newCapacity];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = (T) array[i];
        }
        array = newArray;
    }
}