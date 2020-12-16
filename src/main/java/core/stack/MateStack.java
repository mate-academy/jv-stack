package core.stack;

import java.util.EmptyStackException;

public class MateStack<T> {
    private static final int DEFAULT_SIZE = 10;
    private static final byte GROWTH_FACTOR = 2;
    private T[] stack;
    private int size;

    public MateStack() {
        this.stack = (T[]) new Object[DEFAULT_SIZE];
    }

    public void push(T value) {
        if (size == stack.length) {
            grow();
        }
        stack[size++] = value;
    }

    public T peek() {
        validatePeekAndPop();
        return stack[size - 1];
    }

    public T pop() {
        validatePeekAndPop();
        T value = stack[size - 1];
        stack[size-- - 1] = null;
        return value;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void grow() {
        T[] newStack = (T[]) new Object[stack.length * GROWTH_FACTOR];
        System.arraycopy(stack, 0, newStack, 0, stack.length);
        stack = newStack;
    }

    private void validatePeekAndPop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
    }
}
