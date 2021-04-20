package core.stack;

import java.util.Arrays;
import java.util.EmptyStackException;

public class MateStack<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private T[] elementData;
    private int size;

    public MateStack() {
        elementData = (T[]) new Object[DEFAULT_CAPACITY];
    }

    public void push(T value) {
        if (elementData.length == size) {
            grow();
        }
        elementData[size++] = value;
    }

    public T peek() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        return elementData[size - 1];
    }

    public T pop() {
        T removedElement = peek();
        elementData[size--] = null;
        return removedElement;
    }

    public int size() {
        return size;
    }

    private void grow() {
        int newSize = elementData.length + elementData.length / 2;
        elementData = Arrays.copyOf(elementData, newSize);
    }
}
