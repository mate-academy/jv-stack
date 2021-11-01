package core.stack;

import java.util.EmptyStackException;

public class MateStack<T> {
    private static final int DEFAULT_STACK_SIZE = 10;
    private T[] stackArray;
    private int size;

    public MateStack() {
        stackArray = (T[]) new Object[DEFAULT_STACK_SIZE];
    }

    public void push(T value) {
        if (size == stackArray.length) {
            resize();
        }
        stackArray[size++] = value;
    }

    public T peek() {
        checkSize();
        return stackArray[size - 1];
    }

    public T pop() {
        checkSize();
        T removedObject = stackArray[--size];
        stackArray[size] = null;
        return removedObject;
    }

    public int size() {
        return size;
    }

    private void checkSize() {
        if (size == 0) {
            throw new EmptyStackException();
        }
    }

    private void resize() {
        T[] newArray = (T[]) new Object[stackArray.length * 3 / 2];
        System.arraycopy(stackArray, 0, newArray, 0, stackArray.length);
        stackArray = newArray;
    }
}
