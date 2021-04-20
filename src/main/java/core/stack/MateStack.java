package core.stack;

import java.util.EmptyStackException;

public class MateStack<T> {
    private static final int DEFAULT_STACK_SIZE = 10;
    private static final int GROW_MULTIPLIER = 2;
    private T[] stack;
    private int size;

    public MateStack() {
        stack = (T[]) new Object[DEFAULT_STACK_SIZE];
    }

    public void push(T value) {
        if (size >= stack.length) {
            grow();
        }
        stack[size++] = value;
    }

    public T peek() {
        checkSize();
        return stack[size - 1];
    }

    public T pop() {
        checkSize();
        T lastElement = stack[--size];
        stack[size] = null;
        return lastElement;
    }

    public int size() {
        return size;
    }

    private void grow() {
        T[] biggerStack = (T[]) new Object[stack.length * GROW_MULTIPLIER];
        System.arraycopy(stack, 0, biggerStack, 0, size);
        stack = biggerStack;
    }

    private void checkSize() {
        if (size == 0) {
            throw new EmptyStackException();
        }
    }
}

