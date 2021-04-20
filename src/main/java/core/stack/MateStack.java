package core.stack;

import java.util.EmptyStackException;

public class MateStack<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private T[] stackArray;
    private int size;

    public MateStack() {
        stackArray = (T[]) new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    public void push(T value) {
        if (size == stackArray.length) {
            grow();
        }
        stackArray[size] = value;
        size++;
    }

    public T peek() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        return stackArray[size - 1];
    }

    public T pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        T returnValue = stackArray[size - 1];
        stackArray[size - 1] = null;
        size--;
        return returnValue;
    }

    public int size() {
        return size;
    }

    private void grow() {
        T[] data = stackArray;
        stackArray = (T[]) new Object[size * 3 / 2];
        System.arraycopy(data, 0, stackArray, 0, size);
    }
}
