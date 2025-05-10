package core.stack;

import java.util.EmptyStackException;

public class MateStack<T> {

    private static final int DEFAULT_CAPACITY = 10;
    private T[] array;
    private int size;

    public MateStack() {
        array = (T[]) new Object[DEFAULT_CAPACITY];
    }

    public void push(T value) {
        if (array.length == size) {
            resize();
        }
        array[size] = value;
        size++;
    }

    public T peek() {
        isStackEmpty();
        return array[size - 1];
    }

    public T pop() {
        isStackEmpty();
        T currentValue = array[size - 1];
        array[size - 1] = null;
        size--;
        return currentValue;
    }

    public int size() {
        return size;
    }

    private void resize() {
        T[] newArray = (T[]) new Object[DEFAULT_CAPACITY * 3 / 2];
        System.arraycopy(array, 0, newArray, 0, size);
        array = newArray;
    }

    private void isStackEmpty() {
        if (size <= 0) {
            throw new EmptyStackException();
        }
    }
}
