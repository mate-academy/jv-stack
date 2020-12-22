package core.stack;

import java.util.Arrays;
import java.util.EmptyStackException;

public class MateStack<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private static final int RESIZE_ELEMENT_DATA = 2;
    private Object[] elementData;
    private int size;

    public MateStack() {
        elementData = new Object[DEFAULT_CAPACITY];
    }

    public void push(T value) {
        if (size == elementData.length) {
            resize();
        }
        elementData[size++] = value;
    }

    public T peek() {
        checkSize();
        return (T) elementData[size - 1];
    }

    public T pop() {
        T value = peek();
        elementData[size - 1] = null;
        size--;
        return value;
    }

    public int size() {
        return size;
    }

    private void resize() {
        elementData = Arrays.copyOf(elementData,
                size * RESIZE_ELEMENT_DATA);
    }

    private void checkSize() {
        if (size == 0) {
            throw new EmptyStackException();
        }
    }
}
