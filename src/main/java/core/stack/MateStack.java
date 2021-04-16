package core.stack;

import java.util.EmptyStackException;

public class MateStack<T> {
    private static final int MAX_SIZE = 100;
    private int top;
    private T[] stack = (T[]) new Object[MAX_SIZE];

    public MateStack() {
        top = 0;
    }

    public void push(T value) {
        if (top >= MAX_SIZE - 1) {
            throw new EmptyStackException();
        } else {
            top++;
            stack[top] = value;
        }
    }

    public T peek() {
        if (top <= 0) {
            throw new EmptyStackException();
        } else {
            return stack[top];
        }
    }

    public T pop() {
        if (top <= 0) {
            throw new EmptyStackException();
        } else {
            T removedValue = stack[top];
            top--;
            return removedValue;
        }
    }

    public int size() {
        return top;
    }
}
