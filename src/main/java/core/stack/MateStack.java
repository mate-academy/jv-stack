package core.stack;

import java.util.EmptyStackException;

public class MateStack<T> {
    private static final int DEFAULT_SIZE = 10;
    private static final double DEFAULT_MULTIPLAYER = 1.5;
    private T[] stack;
    private int size;
    private int currentSize;

    @SuppressWarnings("unchecked")
    public MateStack() {
        this.stack = (T[]) new Object[DEFAULT_SIZE];
        currentSize = DEFAULT_SIZE;
    }

    public void push(T value) {
        if (size + 1 == currentSize) {
            resize();
        }
        stack[size] = value;
        size++;
    }

    public T peek() {
        checkIfStackEmpty();
        return stack[size - 1];
    }

    public T pop() {
        checkIfStackEmpty();
        T returnValue = stack[size - 1];
        stack[size - 1] = null;
        size--;
        return returnValue;
    }

    public int size() {
        return size;
    }

    private void checkIfStackEmpty() {
        if (size == 0) {
            throw new EmptyStackException();
        }
    }

    private void resize() {
        currentSize = (int) (currentSize * DEFAULT_MULTIPLAYER);
        System.arraycopy(stack,0,stack,0, currentSize);
    }
}
