package core.stack;

import java.util.EmptyStackException;

public class MateStack<T> {
    private static final int ARRSIZE = 10;
    private static final int CAPASITY = 3 / 2;
    private int size;
    private T[] array;

    public MateStack() {
        array = (T[]) new Object[ARRSIZE];
    }

    public void push(T value) {
        if (size == array.length) {
            array = grow();
        }
        array[size++] = value;
    }

    public T peek() {
        int length = size();
        if (length == 0) {
            throw new EmptyStackException();
        }
        return elementAt(length - 1);
    }

    public T pop() {
        T obj;
        int length = size();
        obj = peek();
        removeElementAt(length - 1);
        return obj;
    }

    public int size() {
        return size;
    }

    private int newCapacity() {
        return size * CAPASITY;
    }

    private T[] grow() {
        T[] growArray = (T[]) new Object[newCapacity()];
        System.arraycopy(array, 0, growArray, 0, size);
        return growArray;
    }

    private T elementAt(int index) {
        if (index >= size) {
            throw new ArrayIndexOutOfBoundsException(index + " >= " + size);
        }
        return array[index];
    }

    private void removeElementAt(int index) {
        if (index >= size) {
            throw new ArrayIndexOutOfBoundsException(index + " >= " + size);
        } else if (index < 0) {
            throw new ArrayIndexOutOfBoundsException("Your index: " + index
                    + ". Must be more then 0");
        }
        int elementMoved = size - index - 1;
        if (elementMoved > 0) {
            System.arraycopy(array, index + 1, array, index, elementMoved);
        }
        size--;
        array[size] = null;
    }
}
