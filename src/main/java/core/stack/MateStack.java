package core.stack;

import java.util.Arrays;
import java.util.EmptyStackException;

public class MateStack<T> {
    private static final int DEFAULT_STACK_SIZE = 10;
    private T[] stack;
    private int size;

    public MateStack() {
        stack = (T[]) new Object[DEFAULT_STACK_SIZE];
    }

    public void push(T value) {
        resize();
        stack[size] = value;
        size++;
    }

    public T peek() {
        return getElement();
    }

    public T pop() {
        T lastElement = getElement();
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

    private T getElement() {
        isEmptyStack();
        return stack[getIndexOfLastElement()];
    }

    private boolean resize() {
        if (size == stack.length) {
            stack = Arrays.copyOf(stack, (int) (stack.length * 1.5));
            return true;
        }
        return false;
    }
}
