package core.stack;

import java.util.EmptyStackException;

public class MateStack<T> {
    private static final int INITIAL_CAPACITY = 10;
    private static final int DIVIDER = 2;
    private T[] arrayOfObjects;
    private int size;

    public MateStack() {
        arrayOfObjects = (T[]) new Object[INITIAL_CAPACITY];
    }

    public void push(T value) {
        increaseCapacity();
        arrayOfObjects[size] = value;
        size++;
    }

    private void increaseCapacity() {
        if (size == arrayOfObjects.length) {
            grow();
        }
    }

    private void grow() {
        T[] tempArray = (T[]) new Object[size + size / DIVIDER];
        System.arraycopy(arrayOfObjects, 0, tempArray, 0, arrayOfObjects.length);
        arrayOfObjects = tempArray;
    }

    public T peek() {
        checkEmptyStack();
        return arrayOfObjects[size - 1];
    }

    public T pop() {
        checkEmptyStack();
        T elementForRemove = arrayOfObjects[size - 1];
        arrayOfObjects[size - 1] = null;
        size--;
        return elementForRemove;
    }

    private void checkEmptyStack() {
        if (size == 0) {
            throw new EmptyStackException();
        }
    }

    public int size() {
        return size;
    }
}
