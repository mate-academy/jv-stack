package core.stack;

import java.util.EmptyStackException;

public class MateStack<T> {
    private static final int INITIAL_CAPACITY = 10;
    private static final int INCREASES_INDEX = 2;
    private T[] elementData;
    private int size;

    public MateStack() {
        size = 0;
        elementData = (T[]) new Object[INITIAL_CAPACITY];
    }

    public void push(T value) {
        checkSize();
        elementData[size] = value;
        size++;
    }

    private void checkSize() {
        if (size == elementData.length) {
            T[] tempArray = (T[]) new Object[size + size / INCREASES_INDEX];
            System.arraycopy(elementData, 0, tempArray, 0, elementData.length);
            elementData = tempArray;
        }
    }

    public T peek() {
        checkEmptyArray();
        return elementData[size - 1];
    }

    public T pop() {
        checkEmptyArray();
        T nodeToRemove = elementData[size - 1];
        elementData[size - 1] = null;
        size--;
        return nodeToRemove;
    }

    private void checkEmptyArray() {
        if (size == 0) {
            throw new EmptyStackException();
        }
    }

    public int size() {
        return size;
    }
}
