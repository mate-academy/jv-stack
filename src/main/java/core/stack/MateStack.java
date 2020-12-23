package core.stack;

import java.util.EmptyStackException;

public class MateStack<T> {
    private static final int INITIAL_CAPACITY = 10;
    private T[] array;
    private int size;

    public MateStack() {
        array = (T[]) new Object[INITIAL_CAPACITY];
    }

    public void push(T value) {
        if (size == array.length) {
            resize();
        }
        array[size] = value;
        size++;
    }

    public T peek() {
        return returnValue();
    }

    public T pop() {
        T lastElement = returnValue();
        array[size - 1] = null;
        size--;
        return lastElement;
    }

    public int size() {
        return size;
    }

    private T returnValue() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        return array[size - 1];
    }

    private void resize() {
        T[] bufferArray = array;
        array = (T[]) new Object[array.length + (array.length >> 1)];
        System.arraycopy(bufferArray, 0, array, 0, bufferArray.length);
    }
}
