package core.stack;

import java.util.EmptyStackException;

public class MateStack<T> {
    private static final int INITIAL_LENGTH = 10;

    private T[] elementData;
    private int size;

    public MateStack() {
        elementData = (T[]) new Object[INITIAL_LENGTH];
    }

    public void push(T value) {
        if (!checkCapacity()) {
            resize();
        }
        elementData[size] = value;
        size++;
    }

    public T peek() {
        if (size() == 0) {
            throw new EmptyStackException();
        }
        return elementData[size - 1];
    }

    public T pop() {
        if (size() == 0) {
            throw new EmptyStackException();
        }
        size--;
        return elementData[size];
    }

    public int size() {
        return size;
    }

    private boolean checkCapacity() {
        return size < elementData.length;
    }

    private void resize() {
        T[] oldData = elementData;
        elementData = (T[]) new Object[getNewCapacity()];
        System.arraycopy(oldData, 0, elementData, 0, size);
    }

    private int getNewCapacity() {
        return elementData.length * 3 / 2 + 1;
    }
}
