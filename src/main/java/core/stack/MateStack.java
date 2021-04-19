package core.stack;

import java.util.EmptyStackException;

public class MateStack<T> {
    private static final int START_ARRAY_CAPACITY = 10;
    private static final double CAPACITY_ARRAY_MULTIPLE = 1.5;
    private int size;
    private T[] stackArray;
    private int capacity;

    public MateStack() {
        capacity = START_ARRAY_CAPACITY;
        stackArray = (T[]) new Object[capacity];
    }

    public void push(T value) {
        checkArraySize();
        stackArray[size] = value;
        size++;
    }

    public T peek() throws EmptyStackException {
        if (size > 0) {
            return stackArray[size - 1];
        }
        throw new EmptyStackException();
    }

    public T pop() throws EmptyStackException {
        if (size > 0) {
            T value = stackArray[size - 1];
            stackArray[size - 1] = null;
            size--;
            return value;
        }
        throw new EmptyStackException();
    }

    public int size() {
        return size;
    }

    private void checkArraySize() {
        if (size == capacity) {
            int newCapacity = (int) (capacity * CAPACITY_ARRAY_MULTIPLE);
            T[] newArray = (T[]) new Object[newCapacity];
            System.arraycopy(stackArray, 0, newArray, 0, stackArray.length);
            stackArray = newArray;
        }
    }
}
