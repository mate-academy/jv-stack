package core.stack;

import java.util.EmptyStackException;

public class MateStack<T> {
    private final int initCapacity = 16;
    private final int growFactor = 2;
    private T[] elementData;
    private int size = 0;

    @SuppressWarnings("unchecked")
    public MateStack() {
        this.elementData = (T[]) new Object[initCapacity];
    }

    public void push(T value) {
        if (size == elementData.length) {
            reSize(elementData.length * growFactor);
        }
        elementData[size] = value;
        size++;
    }

    public T peek() {
        checkIfEmpty();
        return elementData[size - 1];
    }

    public T pop() {
        checkIfEmpty();
        T old = elementData[size - 1];
        elementData[size - 1] = null;
        size--;
        return old;
    }

    public int size() {
        return this.size;
    }

    private void checkIfEmpty() {
        if (size == 0) {
            throw new EmptyStackException();
        }
    }

    private void reSize(int newCapacity) {
        @SuppressWarnings("unchecked")
        T[] newArr = (T[]) new Object[newCapacity];
        System.arraycopy(elementData, 0, newArr, 0, size);
        elementData = newArr;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        for (int i = 0; i < size; i++) {
            sb.append(elementData[i]);
            if (elementData[i + 1] == null) {
                sb.append("]");
            } else {
                sb.append(", ");
            }
        }
        return sb.toString();
    }
}
