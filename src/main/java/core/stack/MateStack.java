package core.stack;

import java.util.EmptyStackException;
import java.util.Objects;

public class MateStack<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private static final double MULTIPLIER = 1.5;
    private T[] stack;
    private int size;

    public MateStack() {
        stack = (T[]) new Object[DEFAULT_CAPACITY];
    }

    public void push(T value) {
        if (size == stack.length) {
            grow();
        }
        for (int i = 0; i < size; i++) {
            if (Objects.equals(stack[i], (value))) {
                return;
            }
        }
        stack[size] = value;
        size++;
    }

    private void grow() {
        T[] oldArray = stack;
        stack = (T[]) new Object[(int)(stack.length * MULTIPLIER)];
        System.arraycopy(oldArray, 0, stack, 0, oldArray.length);
    }

    public T peek() {
        checkStack();
        return stack[size - 1];
    }

    private void checkStack() {
        if (size == 0) {
            throw new EmptyStackException();
        }
    }

    public T pop() {
        checkStack();
        T value = stack[size - 1];
        stack[size - 1] = null;
        size--;
        return value;
    }

    public int size() {
        return size;
    }
}
