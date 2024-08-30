package core.stack;

import java.util.EmptyStackException;

public class MateStack<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE;

    private T[] elementData;
    private int size;

    public MateStack() {
        elementData = (T[]) new Object[DEFAULT_CAPACITY];
    }

    public void push(T value) {
        if (value == null) {
            return;
        }

        resize();
        elementData[size] = value;
        size++;
    }

    private void resize() {
        if (size == elementData.length) {
            int newCapacity = elementData.length * 2;
            if (newCapacity - MAX_ARRAY_SIZE > 0) {
                newCapacity = MAX_ARRAY_SIZE;
            }

            T[] newArray = (T[]) new Object[newCapacity];
            System.arraycopy(elementData, 0, newArray, 0, elementData.length);
            elementData = newArray;
        }
    }

    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        return elementData[size - 1];
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
