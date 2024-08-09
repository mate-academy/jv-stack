package core.stack;

import java.util.EmptyStackException;

public class MateStack<T> {
    private static final int INITIAL_SIZE = 10;
    private static final double GROWTH_FACTOR = 1.5;
    private int currentSize = INITIAL_SIZE;
    private int size = 0;
    private T[] table = createArray(currentSize);

    private T[] createArray(int size) {
        return (T[]) new Object[size];
    }

    public void push(T value) {
        table = grow();
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
        if (size < currentSize) {
            return table;
        }
        int newLength = (int) (table.length * GROWTH_FACTOR);
        currentSize = (int) newLength;
        T[] newTable = createArray(currentSize);
        System.arraycopy(table,0,newTable,0,table.length);
        return newTable;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}




