package core.stack;

import java.util.EmptyStackException;

public class MateStack<T> {
    private static final int INITIAL_SIZE = 10;
    private int currentSize = INITIAL_SIZE;
    private int size = 0;
    private T[] table = (T[]) new Object[currentSize];

    public void push(T value) {
        if (size >= currentSize) {
            table = grow();
        }
        table[size] = value;
        size++;
    }

    public T peek() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        return table[size - 1];
    }

    public T pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        T value = peek();
        table[size - 1] = null;
        size--;
        return value;
    }

    public int size() {
        return size;
    }

    private T[] grow() {
        double newLength = table.length * 1.5;
        currentSize = (int) newLength;
        T[] newTable = (T[]) new Object[currentSize];
        for (int i = 0; i < table.length; i++) {
            newTable[i] = table[i];
        }
        return newTable;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}




