package core.stack;

import java.util.EmptyStackException;
import java.util.Objects;

public class MateStack<T> {
    private static final int INITIAL_ARRAY_SIZE = 10;
    private T[] stack;
    private int capacity;

    public MateStack() {
        stack = (T[]) new Object[INITIAL_ARRAY_SIZE];
    }

    public void push(T value) {
        checkCapacity();
        if (!contains(value)) {
            stack[capacity++] = value;
        }
    }

    public T peek() {
        checkStackForEmptiness();
        return stack[capacity - 1];
    }

    public T pop() {
        checkStackForEmptiness();
        return stack[--capacity];
    }

    public int size() {
        return capacity;
    }

    private boolean contains(T value) {
        for (int i = 0; i <= capacity; i++) {
            if (Objects.equals(stack[i], value)) {
                return true;
            }
        }
        return false;
    }

    private T[] resizeStack() {
        T[] enlargedStack = (T[]) new Object[(capacity * 3) / 2 + 1];
        System.arraycopy(stack, 0, enlargedStack, 0, capacity);
        return enlargedStack;
    }

    private void checkStackForEmptiness() {
        if (capacity == 0) {
            throw new EmptyStackException();
        }
    }

    private void checkCapacity() {
        if (capacity == stack.length) {
            stack = resizeStack();
        }
    }
}
