package core.stack;

import java.util.EmptyStackException;

public class MateStack<T> {
    private T[] elements;
    private int size;
    private static final int INITIAL_CAPACITY = 10;

    @SuppressWarnings("unchecked")
    public MateStack() {
        elements = (T[]) new Object[INITIAL_CAPACITY];
        size = 0;
    }

    public void push(T value) {
        if (size == elements.length) {
            resize();
        }
        elements[size++] = value;
    }

    public T peek() {
        throwExeption();
        return elements[size - 1];
    }

    public T pop() {
        throwExeption();
        T value = elements[--size];
        elements[size] = null;
        return value;
    }

    public int size() {
        return size;
    }

    @SuppressWarnings("unchecked")
    private void resize() {
        T[] newArray = (T[]) new Object[elements.length * 2];
        System.arraycopy(elements, 0, newArray, 0, elements.length);
        elements = newArray;
    }

    private void throwExeption() {
        if (size == 0) {
            throw new EmptyStackException();
        }
    }


}
