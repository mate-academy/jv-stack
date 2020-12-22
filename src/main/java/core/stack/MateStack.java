package core.stack;

import java.util.EmptyStackException;

public class MateStack<T> {
    private final static float LOAD_COEFFICIENT = 1.5f;
    private T[] stack;
    private int size;
    private int capacity;

    public MateStack() {
        size = 0;
        capacity = 10;
        stack = (T[]) new Object[capacity];
    }

    public void push(T value) {
        if (size > capacity) {
            grow();
        }
        stack[size] = value;
        size++;
    }

    public T peek() {
        return peekItem();
    }

    public T pop() {
        return popItem();
    }

    public int size() {
        return size;
    }

    private void grow() {
        capacity *= LOAD_COEFFICIENT;
        T[] newStack = (T[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            newStack[i] = stack[i];
        }
        stack = newStack;
    }

    private T peekItem() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        return stack[size - 1];
    }

    private T popItem() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        T lastItem = stack[size - 1];
        size--;
        return lastItem;
    }
}
