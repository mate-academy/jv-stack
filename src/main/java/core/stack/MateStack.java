package core.stack;

import java.util.EmptyStackException;

public class MateStack<T> {
    private final int INIT_CAPACITY = 16;
    private final int GROW_FACTOR = 2;
    private T[] elementData;
    private int size = 0;

    @SuppressWarnings("unchecked")
    public MateStack() {
        this.elementData = (T[]) new Object[INIT_CAPACITY];
    }

    public void push(T value) {
        if (size == elementData.length) {
            reSize(elementData.length * GROW_FACTOR);
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
        System.arraycopy(elementData, 0, newArr, 0, elementData.length);
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
