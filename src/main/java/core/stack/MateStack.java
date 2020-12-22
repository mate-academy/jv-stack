package core.stack;

import java.util.EmptyStackException;

public class MateStack<T> {
    private static final float LOAD_COEFFICIENT = 1.5f;
    private static final int DEFAULT_CAPACITY = 10;
    private T[] stack;
    private int size;
    private int capacity;

    public MateStack() {
        size = 0;
        capacity = DEFAULT_CAPACITY;
        stack = (T[]) new Object[capacity];
    }

    public void push(T value) {
        if (size >= capacity) {
            grow();
        }
        stack[size] = value;
        size++;
    }

    public T peek() {
        return getLastItem();
    }

    public T pop() {
        T lastItem = getLastItem();
        stack[size - 1] = null;
        size--;
        return lastItem;
    }

    public int size() {
        return size;
    }

    private void grow() {
        capacity *= LOAD_COEFFICIENT;
        T[] newStack = (T[]) new Object[capacity];
        copyItems(newStack);
    }

    private T getLastItem() {
        if (size != 0) {
            return stack[size - 1];
        }
        throw new EmptyStackException();
    }

    private void copyItems(T[] tempStack) {
        for (int i = 0; i < size; i++) {
            tempStack[i] = stack[i];
        }
        stack = tempStack;
    }
}
