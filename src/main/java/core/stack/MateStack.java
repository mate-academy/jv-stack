package core.stack;

import java.util.EmptyStackException;

public class MateStack<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private T[] stack;
    private int size;

    public MateStack() {
        this.stack = (T[]) new Object[DEFAULT_CAPACITY];
    }

    public void push(T value) {
        if (size == stack.length) {
            grow();
        }
        stack[size++] = value;
    }

    public T peek() {
        checkIfEmpty();
        return stack[size - 1];
    }

    public T pop() {
        checkIfEmpty();
        T value = stack[size - 1];
        T[] newStack = (T[]) new Object[size];
        System.arraycopy(stack, 0, newStack, 0, size - 1);
        size--;
        return value;
    }

    public int size() {
        return size;
    }

    private void grow() {
        int oldCapacity = stack.length;
        if (oldCapacity > 0) {
            int newCapacity = oldCapacity + (oldCapacity / 2);
            T[] bufferArray = (T[]) new Object[oldCapacity];
            System.arraycopy(stack, 0, bufferArray,0, size);
            stack = (T[]) new Object[newCapacity];
            System.arraycopy(bufferArray, 0, stack,0, size);
        }
    }

    private void checkIfEmpty() {
        if (size - 1 < 0) {
            throw new EmptyStackException();
        }
    }
}
