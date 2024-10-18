package core.stack;

import java.util.EmptyStackException;

public class MateStack<T> {
    private static final int DEFAULT_SIZE = 8;
    private Object[] stack;
    //private T[] stack;
    //Type parameter 'T' cannot be instantiated directly
    private int size = 0;
    private final int multiplier = 2;

    public MateStack() {
        stack = new Object[DEFAULT_SIZE];
    }

    public void grow() {
        if (size < stack.length) {
            int newCapacity = size * multiplier;
            System.arraycopy(stack, 0, stack = new Object[newCapacity], 0, size);
        }
    }

    public void push(T value) {
        if (size < stack.length) {
            stack[size] = value;
            size++;
        } else {
            grow();
        }
    }

    public T peek() {
        if (size > 0) {
            return (T) stack[size - 1];
        } else {
            throw new EmptyStackException();
        }
    }

    public T pop() {
        if (size > 0) {
            Object value = stack[size - 1];
            size--;
            return (T) value;
        } else {
            throw new EmptyStackException();
        }
    }

    public int size() {
        return size;
    }
}

