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
        if (size >= currentSize) {
            resize();
        }
        table[size] = value;
        size++;
    }

    public T peek() {
        checkSize();
        return table[size - 1];
    }

    public T pop() {
        checkSize();
        T value = peek();
        table[size - 1] = null;
        size--;
        return value;
    }

    public int size() {
        return size;
    }

    private void resize() {
        currentSize = (int) (table.length * GROWTH_FACTOR);
        System.arraycopy(table,0,table,0,currentSize);
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void checkSize() {
        if (size == 0) {
            throw new EmptyStackException();
        }
    }
}




