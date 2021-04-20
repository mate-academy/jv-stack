package core.stack;

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

    public T peek() {
        int len = size();
        if (len == 0) {
            throw new EmptyStackException();
        }
        return (T) array[len - 1];
    }

    public T pop() {
        T object = peek();
        size--;
        return object;
    }

    public int size() {
        return size;
    }

    private T[] grow() {
        T[] grewArray = (T[]) new Object[size + (size / 2)];
        System.arraycopy(array, 0, grewArray, 0, size);
        return grewArray;
    }
}
