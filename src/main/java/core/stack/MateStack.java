package core.stack;

import java.util.EmptyStackException;

public class MateStack<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] elementData;
    private int size;

    public MateStack() {
        elementData = new Object[DEFAULT_CAPACITY];
    }

    public void push(T value) {
        ensureCapacity();
        elementData[size] = value;
        size++;
    }

    private void ensureCapacity() {
        if (size == elementData.length) {
            int newCapacity = elementData.length * 2;
            Object[] newArray = new Object[newCapacity];
            System.arraycopy(elementData, 0, newArray, 0, elementData.length);
            elementData = newArray;
        }
    }

    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        return (T) elementData[size - 1];
    }

    private boolean isEmpty() {
        return size == 0;
    }

    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        size--;
        T element = (T) elementData[size];
        elementData[size] = null;
        return element;
    }

    public int size() {
        return size;
    }
}
