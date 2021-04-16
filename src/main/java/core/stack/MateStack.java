package core.stack;

import java.util.EmptyStackException;

public class MateStack<T> {
    private static final int MAX_SIZE = 100;
    private int size;
    private T[] stack;

    public MateStack() {
        stack = (T[]) new Object[MAX_SIZE];
        size = 0;
    }

    public void push(T value) {
        if (size >= MAX_SIZE - 1) {
            throw new RuntimeException("Stack is overflow");
        }

        stack[size] = value;
        size++;
    }

    public T peek() {
        if (size <= 0) {
            throw new EmptyStackException();
        }

        return stack[size - 1];
    }

    public T pop() {
        if (size <= 0) {
            throw new EmptyStackException();
        }

        T removedValue = stack[size - 1];
        size--;
        return removedValue;
    }

    public int size() {
        return size;
    }
}
