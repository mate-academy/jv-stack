package core.stack;

import java.util.EmptyStackException;

public class MateStack<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private T[] stack;
    private int size;

    public MateStack() {
        stack = (T[]) new Object[DEFAULT_CAPACITY];
    }

    public void push(T value) {
        stack[size++] = value;
        resize();
    }

    public T peek() {
        return getValue();
    }

    public T pop() {
        T oldValue = getValue();
        stack[--size] = null;
        return oldValue;
    }

    public int size() {
        return size;
    }

    private void resize() {
        if (size == stack.length) {
            T[] oldStack = stack;
            stack = (T[]) new Object[size + (size >> 1)];
            System.arraycopy(oldStack, 0, stack, 0, size);
        }
    }

    private T getValue() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        return stack[size - 1];
    }
}
