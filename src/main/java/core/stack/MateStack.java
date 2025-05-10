package core.stack;

import java.util.EmptyStackException;

public class MateStack<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private int capacity;
    private int size;
    private Object[] stack;

    public MateStack() {
        this.capacity = DEFAULT_CAPACITY;
        this.stack = new Object[capacity];
        this.size = 0;
    }

    private void resize() {
        capacity = capacity + (capacity >> 2) + 1;
        Object[] newStack = new Object[capacity];
        System.arraycopy(stack, 0, newStack, 0, stack.length);
        stack = newStack;
    }

    public void push(T value) {
        if (size == stack.length) {
            resize();
        }
        stack[size] = value;
        size++;
    }

    public T peek() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        return (T) stack[size - 1];
    }

    public T pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        T lastElement = (T) stack[size - 1];
        System.arraycopy(stack, 0, stack, 0, stack.length - 1);
        size--;
        return lastElement;
    }

    public int size() {
        return size;
    }
}
