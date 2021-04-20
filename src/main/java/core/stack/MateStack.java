package core.stack;

import java.util.EmptyStackException;

public class MateStack<T> {
    private static final int INITIAL_CAPACITY = 10;
    private T[] elements;
    private int size;
    private int topOfStack;

    public MateStack() {
        this.elements = (T[]) new Object[INITIAL_CAPACITY];
        this.size = 0;
        this.topOfStack = -1;
    }

    public void push(T value) {
        if (size == elements.length) {
            extendArray();
        }
        elements[++topOfStack] = value;
        size++;
    }

    public T peek() {
        if (topOfStack < 0) {
            throw new EmptyStackException();
        }
        return elements[topOfStack];
    }

    public T pop() {
        if (topOfStack < 0) {
            throw new EmptyStackException();
        }
        size--;
        return elements[topOfStack--];
    }

    public int size() {
        return size;
    }

    private void extendArray() {
        int newCapacity = Math.round((size * 3) / 2 + 1);
        T[] extendedArray = (T[]) new Object[newCapacity];
        System.arraycopy(elements, 0, extendedArray, 0, size);
        elements = extendedArray;
    }
}
