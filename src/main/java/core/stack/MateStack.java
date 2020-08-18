package core.stack;

import java.util.Arrays;

public class MateStack<T> {
    private static final int CAPACITY = 10;
    private T[] stack;
    private int size;

    public MateStack() {
        stack = (T[]) new Object[CAPACITY];
        size = 0;
    }

    public void push(T value) {
        resize();
        stack[size++] = value;
    }

    public T peek() {
        if (size == 0) {
            throw new IndexOutOfBoundsException("Stack is empty");
        }
        return stack[size - 1];
    }

    public T pop() {
        if (size == 0) {
            throw new IndexOutOfBoundsException("Stack is empty");
        }
        T value = stack[size - 1];
        stack[size - 1] = null;
        size--;
        return value;
    }

    public int size() {
        return size;
    }

    private void resize() {
        if (size == stack.length) {
            stack = Arrays.copyOf(stack, (stack.length + (stack.length >> 1)));
        }
    }
}
