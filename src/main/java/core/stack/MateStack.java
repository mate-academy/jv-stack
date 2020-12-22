package core.stack;

import java.util.EmptyStackException;

public class MateStack<T> {
    private T[] stack;
    private int size;
    private int capacity;

    public MateStack() {
        size = 0;
        capacity = 10;
        stack = (T[]) new Object[capacity];
    }

    public void push(T value) {
        size++;
        if (size > capacity) {
            grow();
        }
        stack[size - 1] = value;
    }

    public T peek() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        return stack[size - 1];
    }

    public T pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        T lastItem = stack[size - 1];
        size--;
        return lastItem;
    }

    public int size() {
        return size;
    }

    private void grow() {
        capacity *= 1.5;
        T[] newStack = (T[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            newStack[i] = stack[i];
        }
        stack = newStack;
    }
}
