package core.stack;

import java.util.EmptyStackException;

public class MateStack<T> {
    private static final float LOAD_COEFFICIENT = 1.5f;
    private static final int DEFAULT_CAPACITY = 10;
    private T[] stack;
    private int size;

    public MateStack() {
        size = 0;
        stack = (T[]) new Object[DEFAULT_CAPACITY];
    }

    public void push(T value) {
        if (size >= stack.length) {
            grow();
        }
        stack[size] = value;
        size++;
    }

    public T peek() {
        return getLastItem();
    }

    public T pop() {
        T lastItem = getLastItem();
        stack[size - 1] = null;
        size--;
        return lastItem;
    }

    public int size() {
        return size;
    }

    private void grow() {
        int newLength = (int) (LOAD_COEFFICIENT * stack.length);
        T[] newStack = (T[]) new Object[newLength];
        System.arraycopy(stack, 0, newStack, 0, stack.length);
        stack = newStack;
    }

    private T getLastItem() {
        if (size != 0) {
            return stack[size - 1];
        }
        throw new EmptyStackException();
    }
}
