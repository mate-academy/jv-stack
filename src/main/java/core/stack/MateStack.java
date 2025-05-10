package core.stack;

import java.util.Arrays;
import java.util.EmptyStackException;

public class MateStack<T> {
    private static final int INITIAL_CAPACITY = 10;
    private static final int CAPACITY_MULTIPLIER = 2;
    private Object[] stack;
    private int size;

    public MateStack() {
        stack = new Object[INITIAL_CAPACITY];
    }

    public void push(T value) {
        if (size == stack.length) {
            growStack();
        }
        stack[size] = value;
        size++;
    }

    public T peek() {
        checkStack();
        return (T) stack[size - 1];
    }

    public T pop() {
        checkStack();
        T result = (T) stack[size - 1];
        size--;
        return result;
    }

    public int size() {
        return size;
    }

    private void growStack() {
        stack = Arrays.copyOf(stack, stack.length * CAPACITY_MULTIPLIER);
    }

    private void checkStack() {
        if (size == 0) {
            throw new EmptyStackException();
        }
    }
}
