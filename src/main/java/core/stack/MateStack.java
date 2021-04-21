package core.stack;

import java.util.EmptyStackException;

public class MateStack<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private static final double SIZE_MULTIPLICATION = 1.5;
    private int size;
    private T[] array;

    public MateStack() {
        array = (T[]) new Object[DEFAULT_CAPACITY];
    }

    public void push(T value) {
        if (size == array.length) {
            reSize();
        }
        array[size] = value;
        size++;
    }

    public T peek() {
        checkEmpty();
        return array[size - 1];
    }

    public T pop() {
        checkEmpty();
        T returnElement = array[size - 1];
        array[size - 1] = null;
        size--;
        return returnElement;
    }

    public int size() {
        return size;
    }

    public void reSize() {
        T[] newArray = (T[]) new Object[(int) (array.length * SIZE_MULTIPLICATION)];
        System.arraycopy(array, 0, newArray, 0, array.length - 1);
        array = newArray;
    }

    public void checkEmpty() {
        if (size == 0) {
            throw new EmptyStackException();
        }
    }
}
