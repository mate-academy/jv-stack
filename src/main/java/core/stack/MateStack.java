package core.stack;

import java.util.Arrays;
import java.util.EmptyStackException;

public class MateStack<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] array;
    private int size;

    public MateStack() {
        array = new Object[DEFAULT_CAPACITY];
    }

    public void push(T value) {
        if (array.length == size) {
            grow();
        }
        array[size++] = value;
    }

    private void grow() {
        array = Arrays.copyOf(array, array.length + (array.length / 2));
    }

    public T peek() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        return (T) array[size - 1];
    }

    public T pop() {
        T object = peek();
        size--;
        return object;
    }

    public int size() {
        return size;
    }
}
