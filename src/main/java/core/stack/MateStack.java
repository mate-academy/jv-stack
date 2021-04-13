package core.stack;

import java.util.EmptyStackException;

public class MateStack<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private int size;
    private T[] content;

    public MateStack() {
        content = (T[]) new Object[DEFAULT_CAPACITY];
    }

    public void push(T value) {
        resizeArrayIfNeeded();
        content[size++] = value;
    }

    public T peek() {
        checkIsEmpty();
        return content[size - 1];
    }

    public T pop() {
        checkIsEmpty();
        int index = size - 1;
        T valueToRemove = content[index];
        content[index] = null;
        size--;
        return valueToRemove;
    }

    public int size() {
        return size;
    }

    private void checkIsEmpty() {
        if (size == 0) {
            throw new EmptyStackException();
        }
    }

    private void resizeArrayIfNeeded() {
        if (size == content.length) {
            T[] resizedArray = (T[]) new Object[size + (size / 2)];
            System.arraycopy(content, 0, resizedArray, 0, size);
            content = resizedArray;
        }
    }
}
