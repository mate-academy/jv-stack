package core.stack;

import java.util.EmptyStackException;

public class MateStack<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private T[] stack;
    private int size = 0;

    public MateStack() {
        stack = (T[]) new Object[DEFAULT_CAPACITY];
    }

    public void push(T value) {
        resize();
        stack[size] = value;
        size++;
    }

    public T peek() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        return stack[size - 1];
    }

    public T pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        T topElement = stack[size - 1];
        stack[size - 1] = null;
        size--;
        return topElement;
    }

    public int size() {
        return size;
    }

    private void resize() {
        if (size == stack.length) {
            T[] newStack = (T[]) new Object[(stack.length + (stack.length >> 1))];
            System.arraycopy(stack, 0, newStack, 0, size);
            stack = newStack;
        }
    }
}
