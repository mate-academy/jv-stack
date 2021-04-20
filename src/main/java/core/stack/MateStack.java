package core.stack;

import java.util.EmptyStackException;

public class MateStack<T> {
    private static final int ARRSIZE = 10;
    private int size;
    private T[] array;
    private int elementCount;

    public MateStack() {
        array = (T[]) new Object[ARRSIZE];
    }

    public void push(T value) {
        if (size == array.length) {
            array = grow();
        }
        array[size++] = value;
        elementCount++;
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
        size--;
        return obj;
    }

    public int size() {
        return size;
    }

    private int newCapacity() {
        return (size * 3) / 2;
    }

    private T[] grow() {
        T[] growArray = (T[]) new Object[newCapacity()];
        System.arraycopy(array, 0, growArray, 0, size);
        return growArray;
    }

    private T elementAt(int index) {
        if (index >= elementCount) {
            throw new ArrayIndexOutOfBoundsException(index + " >= " + elementCount);
        }
        return array[index];
    }

    private void removeElementAt(int index) {
        if (index >= elementCount) {
            throw new ArrayIndexOutOfBoundsException(index + " >= " + elementCount);
        } else if (index < 0) {
            throw new ArrayIndexOutOfBoundsException("Your index: " + index
                    + ". Must be more then 0");
        }
        int elementMoved = elementCount - index - 1;
        if (elementMoved > 0) {
            System.arraycopy(array, index + 1, array, index, elementMoved);
        }
        elementCount--;
        array[elementCount] = null;
    }
}
