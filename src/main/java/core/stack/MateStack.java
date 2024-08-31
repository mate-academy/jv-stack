package core.stack;

import java.util.EmptyStackException;

public class MateStack<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE;
    private static final int DEFAULT_MULTIPLIER = 2;

    private T[] elementData;
    private int size;
    private int currentMaxSize;

    public MateStack() {
        elementData = (T[]) new Object[DEFAULT_CAPACITY];
        currentMaxSize = DEFAULT_CAPACITY;
    }

    public void push(T value) {
        if (value == null) {
            return;
        }
        if (size == currentMaxSize) {
            resize();
        }

        elementData[size] = value;
        size++;
    }

    private void resize() {
        if (size == elementData.length) {
            int newCapacity = currentMaxSize * DEFAULT_MULTIPLIER;
            if (newCapacity - MAX_ARRAY_SIZE > 0) {
                newCapacity = MAX_ARRAY_SIZE;
            }

            T[] newArray = (T[]) new Object[newCapacity];
            System.arraycopy(elementData, 0, newArray, 0, elementData.length);
            elementData = newArray;
        }
    }

    public T peek() {
        checkIfStackEmpty();
        return elementData[size - 1];
    }

    private void checkIfStackEmpty() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
    }

    private boolean isEmpty() {
        return size == 0;
    }

    public T pop() {
        checkIfStackEmpty();
        size--;
        T element = (T) elementData[size];
        elementData[size] = null;
        return element;
    }

    public int size() {
        return size;
    }
}
