package core.stack;

import java.util.EmptyStackException;

public class MateStack<T> {
    private static final int DEFAULT_STACK_SIZE = 10;
    private static final int GROW_MULTIPLIER = 2;
    private Object[] stack;
    private int size;

    public MateStack() {
        stack = new Object[DEFAULT_STACK_SIZE];
        size = 0;
    }

    public void push(T value) {
        if (stack.length >= size) {
            grow();
        }
        stack[size++] = value;
    }

    public T peek() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        return (T) stack[size - 1];
    }

    public T pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        T lastElement = (T) stack[size - 1];
        stack[size-- - 1] = null;
        return lastElement;
    }

    public int size() {
        return size;
    }

    private void grow() {
        Object[] biggerStack = new Object[stack.length * GROW_MULTIPLIER];
        System.arraycopy(stack, 0, biggerStack, 0, size);
        stack = biggerStack;
    }
}

