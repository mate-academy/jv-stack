package core.stack;

import java.util.EmptyStackException;
import java.util.Objects;

public class MateStack<T> {
    private static final int INITIAL_CAPACITY = 10;
    private T[] stack;
    private int size;

    public MateStack() {
        stack = (T[]) new Object[INITIAL_CAPACITY];
    }

    public void push(T value) {
        checkCapacity();
        if (!contains(value)) {
            stack[size++] = value;
        }
    }

    public T peek() {
        checkStackIsEmpty();
        return stack[size - 1];
    }

    public T pop() {
        checkStackIsEmpty();
        T actualElement = peek();
        stack[--size] = null;
        return actualElement;
    }

    public int size() {
        return size;
    }

    private boolean contains(T value) {
        for (int i = 0; i <= size; i++) {
            if (Objects.equals(stack[i], value)) {
                return true;
            }
        }
        return false;
    }

    private T[] resize() {
        T[] enlargedStack = (T[]) new Object[(size * 3) / 2 + 1];
        System.arraycopy(stack, 0, enlargedStack, 0, size);
        return enlargedStack;
    }

    private void checkStackIsEmpty() {
        if (size == 0) {
            throw new EmptyStackException();
        }
    }

    private void checkCapacity() {
        if (size == stack.length) {
            stack = resize();
        }
    }
}
