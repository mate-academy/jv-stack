package core.stack;

import java.util.EmptyStackException;

public class MateStack<T> {
    private static int GROWTH_FACTOR;
    private T[] stack;
    private int size;
    private int capacity;

    public MateStack() {
        GROWTH_FACTOR = 2;
        capacity = 10;
        stack = (T[]) new Object[capacity];
        size = 0;
    }

    public MateStack(int defaultCapacity, int growthFactor) {
        GROWTH_FACTOR = growthFactor;
        capacity = defaultCapacity;
        stack = (T[]) new Object[defaultCapacity];
        size = 0;
    }

    public void push(T value) {
        if (size >= capacity) {
            grow();
        }
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
        T poppedElement = peek();
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
