package core.stack;

import java.util.EmptyStackException;

public class MateStack<T> {
    public static final int DEFAULT_CAPACITY = 10;
    public static final int MULTIPLICATOR = 2;

    private T[] stackArray;
    private int size;

    public MateStack() {
        this.stackArray = (T[]) new Object[DEFAULT_CAPACITY];
    }

    public void push(T value) {
        resize();
        stackArray[size] = value;
        size++;
    }

    public T peek() {
        emptyStack();
        return stackArray[size - 1];
    }

    public T pop() {
        emptyStack();
        T removedElement = stackArray[size - 1];
        stackArray[--size] = null;
        return removedElement;
    }

    public int size() {
        return size;
    }

    public void resize() {
        if (size == stackArray.length) {
            T[] newStackArray = (T[]) new Object[stackArray.length * MULTIPLICATOR];
            System.arraycopy(stackArray, 0, newStackArray, 0, stackArray.length);
            stackArray = newStackArray;
        }
    }

    public void emptyStack() {
        if (size == 0) {
            throw new EmptyStackException();
        }
    }
}
