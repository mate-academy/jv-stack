package core.stack;

import java.util.Arrays;
import java.util.EmptyStackException;

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
            resize();
        }
        stack[size++] = value;
    }

    public T peek() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        return stack[size - 1];
    }

    public T pop() {
        T request = peek();
        stack[--size] = null;
        return request;
    }

    public int size() {
        return size;
    }

    private void resize() {
        stack = Arrays.copyOf(stack, (int)(stack.length * MULTIPLIER));
    }
}
