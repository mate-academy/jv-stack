package core.stack;

import java.util.Arrays;
import java.util.EmptyStackException;

public class MateStack<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private int size;
    private T[] container;

    public MateStack() {
        container = (T[]) new Object[DEFAULT_CAPACITY];
    }

    public void push(T value) {
        if (size == container.length) {
            resize();
        }
        container[size++] = value;
    }

    private void resize() {
        container = Arrays.copyOf(container, container.length + (container.length >> 1));
    }

    public T peek() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        return container[size - 1];
    }

    public T pop() {
        T value = peek();
        container[--size] = null;
        return value;
    }

    public int size() {
        return size;
    }
}
