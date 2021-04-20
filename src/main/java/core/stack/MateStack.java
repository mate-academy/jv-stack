package core.stack;

import java.util.Arrays;
import java.util.EmptyStackException;

public class MateStack<T> {
    private static final int INITIAL_SIZE = 10;
    private static final double SIZE_MULTIPLIER = 1.5;
    private int size;
    private T[] table;

    public MateStack() {
        table = (T[]) new Object[INITIAL_SIZE];
    }

    public void push(T value) {
        if (size == table.length) {
            grow();
        }
        table[size++] = value;
    }

    private void grow() {
        table = Arrays.copyOf(table, (int) (table.length * SIZE_MULTIPLIER));
    }

    public T peek() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        return table[size - 1];
    }

    public T pop() {
        T value = peek();
        table[--size] = null;
        return value;
    }

    public int size() {
        return size;
    }
}
