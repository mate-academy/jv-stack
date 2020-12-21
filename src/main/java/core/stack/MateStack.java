package core.stack;

import java.util.EmptyStackException;

public class MateStack<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private T[] stack;
    private int size;

    public MateStack() {
        stack = (T[]) new Object[DEFAULT_CAPACITY];
    }

    public void push(T value) {
        if (size == stack.length) {
            grow();
        }
        stack[size++] = value;
    }

    public T peek() {
        checkIfEmpty();
        return stack[size - 1];
    }

    public T pop() {
        checkIfEmpty();
        T value = stack[size - 1];
        stack[size-- - 1] = null;
        return value;
    }

    public int size() {
        return size;
    }

    private void grow() {
        int capacity = stack.length;
        capacity += capacity / 2;
        T[] bufferArray = (T[]) new Object[capacity];
        System.arraycopy(stack, 0, bufferArray,0, size);
        stack = bufferArray;
    }

    private void checkIfEmpty() {
        if (size == 0) {
            throw new EmptyStackException();
        }
    }
}
