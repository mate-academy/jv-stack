package core.stack;

import java.util.EmptyStackException;

public class MateStack<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private T[] stack;
    private int size;

    public MateStack() {
        stack = (T[]) new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    public void push(T value) {
        stack[size++] = value;
        resize();
    }

    public T peek() {
        T value = getValue(size);
        checkToEmpty(value);
        return value;
    }

    public T pop() {
        T oldValue = getValue(size);

        checkToEmpty(oldValue);

        T[] oldStack = stack;
        stack = (T[]) new Object[size - 1];
        System.arraycopy(oldStack, 0, stack, 0, --size);
        return oldValue;
    }

    public int size() {
        return size;
    }

    private void resize() {
        if (size == stack.length) {
            T[] oldStack = stack;
            stack = (T[]) new Object[size + 1];
            System.arraycopy(oldStack, 0, stack, 0, size);
        }
    }

    private void checkToEmpty(T value) {
        if (value == null) {
            throw new EmptyStackException();
        }
    }

    private T getValue(int position) {
        if (position > 0) {
            return stack[position - 1];
        }
        if (position == 0) {
            return stack[0];
        }
        return null;
    }
}
