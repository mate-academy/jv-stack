package core.stack;

import java.util.EmptyStackException;

public class MateStack<T> {
    private static final int ARRSIZE = 10;
    private static final int CAPACITY = 3 / 2;
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
        if (size == 0) {
            throw new EmptyStackException();
        }
        return elementAt(size - 1);
    }

    public T pop() {
        T obj;
        obj = peek();
        removeElementAt(size - 1);
        return obj;
    }

    public int size() {
        return size;
    }

    private int newCapacity() {
        return size * CAPACITY;
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
