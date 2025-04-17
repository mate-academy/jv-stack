package core.stack;

import java.util.Arrays;
import java.util.EmptyStackException;

public class MateStack<T> {
    private static final int DEFAULT_SIZE = 8;
    private Object[] stack;
    private int size = 0;

    public MateStack() {
        stack = new Object[DEFAULT_SIZE];
        Arrays.fill(stack, null);
    }

    public void push(T value) {
        if (size < stack.length) {
            stack[size] = value;
            size++;
        }
    }

    private void resizeStack() {
        int newSize = stack.length * 2;
        Object[] newStack = new Object[newSize];
        System.arraycopy(stack, 0, newStack, 0, stack.length);
        stack = newStack;
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
            stack[size - 1] = null;
            size = size - 1;
            return (T) value;
        } else {
            throw new EmptyStackException();
        }
    }

    public int size() {
        return size;
    }
}
