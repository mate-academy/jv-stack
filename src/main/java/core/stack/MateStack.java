package core.stack;

import java.util.EmptyStackException;

public class MateStack<T> {
    private static final int GROWTH_FACTOR = 2;
    private T[] stack;
    private int size;
    private int capacity;

    public MateStack() {
        int defaultCapacity = 10;
        stack = (T[]) new Object[defaultCapacity];
        size = 0;
        capacity = defaultCapacity;
    }

    public void push(T value) {
        if (size >= capacity) {
            grow();
        }
        stack[size] = value;
        size++;
    }

    public T peek() throws EmptyStackException {
        if (size == 0) {
            throw new EmptyStackException();
        }
        return stack[size - 1];
    }

    public T pop() throws EmptyStackException {
        if (size == 0) {
            throw new EmptyStackException();
        }
        T poppedElement = stack[size - 1];
        stack[size - 1] = null;
        size--;
        return poppedElement;
    }

    public int size() {
        return size;
    }

    private void grow() {
        T[] oldStack = stack;
        capacity *= GROWTH_FACTOR;
        stack = (T[]) new Object[capacity];
        System.arraycopy(oldStack, 0, stack, 0, size);
    }
}
