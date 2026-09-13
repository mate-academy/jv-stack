package core.stack;

import java.util.EmptyStackException;

public class MateStack<T> {
    private T[] stack = (T[]) new Object[10];
    private int size;

    public void push(T value) {
        if (size == stack.length) {
            resize();
        }
        stack[size++] = value;
    }

    public T peek() {
        validateNotEmpty();
        return stack[size - 1];
    }

    public T pop() {
        validateNotEmpty();
        T value = stack[--size];
        stack[size] = null;
        return value;
    }

    public int size() {
        return size;
    }

    private void validateNotEmpty() {
        if (size == 0) {
            throw new EmptyStackException();
        }
    }

    private void resize() {
        T[] newStack = (T[]) new Object[stack.length * 2];
        System.arraycopy(stack, 0, newStack, 0, stack.length);
        stack = newStack;
    }
}
