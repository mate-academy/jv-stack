package core.stack;

import java.util.EmptyStackException;

public class MateStack<T> {
    private static final int DEFAULT_STACK_SIZE = 10;
    private T[] stack;
    private int size;

    public MateStack() {
        stack = (T[]) new Object[DEFAULT_STACK_SIZE];
        size = 0;
    }

    public void push(T value) {
        stack[size] = value;
        size++;
    }

    public T peek() {
        isEmptyStack();
        return stack[getIndexOfLastElement()];
    }

    public T pop() {
        isEmptyStack();
        T lastElement = stack[getIndexOfLastElement()];
        stack[getIndexOfLastElement()] = null;
        size--;
        return lastElement;
    }

    public int size() {
        return size;
    }

    private void isEmptyStack() {
        if (size == 0) {
            throw new EmptyStackException();
        }
    }

    private int getIndexOfLastElement() {
        return size - 1;
    }
}
