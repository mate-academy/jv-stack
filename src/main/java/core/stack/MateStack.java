package core.stack;

import java.util.EmptyStackException;

public class MateStack<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private T[] elements;
    private int size;

    public MateStack() {
        elements = (T[]) new Object[DEFAULT_CAPACITY];
    }

    public void push(T value) {
        if (size == elements.length) {
            increaseCapacity();
        }
        elements[++size] = value;
    }

    public T peek() {
        checkNull();
        return elements[size];
    }

    public T pop() {
        checkNull();
        T current = peek();
        elements[size--] = null;
        return current;
    }

    public int size() {
        return size;
    }

    private void checkNull() {
        if (size == 0) {
            throw new EmptyStackException();
        }
    }

    private void increaseCapacity() {
        T[] biggerArray = (T[]) new Object[size + (size / 2)];
        System.arraycopy(elements, 0, biggerArray, 0, size);
        elements = biggerArray;
    }
}
