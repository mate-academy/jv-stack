package core.stack;

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
        if (empty() == true) {
            throw new EmptyStackException();
        }
        return elementData[size - 1];
    }

    public T pop() {
        if (empty() == true) {
            throw new EmptyStackException();
        }
        T removedElement = peek();
        elementData[size--] = null;
        return removedElement;
    }

    public int size() {
        return size;
    }

    public boolean empty() {
        return size == 0;
    }

    private void grow() {
        T[] newElementData = (T[]) new Object[elementData.length
                                        + elementData.length / 2];
        System.arraycopy(elementData, 0, newElementData, 0, size);
        elementData = newElementData;
    }
}
