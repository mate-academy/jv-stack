package core.stack;

import java.util.ArrayList;

public class MateStack<T> {

    private static final int INITIAL_CAPACITY = 10;
    private T[] data;
    private int size;

    public MateStack() {
        data = (T[]) new Object[INITIAL_CAPACITY];
        size = 0;
    }

    public void push(T value) {
        resize();
        data[size] = value;
        size++;
    }

    public T peek() {
        if (size == 0) {
            throw new IndexOutOfBoundsException("Stack is empty");
        }
        return data[size - 1];
    }

    public T pop() {
        if (size == 0) {
            throw new IndexOutOfBoundsException("Stack is empty");
        }
        T value = data[size - 1];
        data[size - 1] = null;
        size--;
        return value;
    }

    public int size() {
        return size;
    }

    private void resize() {
        int length = data.length;
        if (size == length - 1) {
            T[] temp = (T[]) new Object[length + length >> 1];
            System.arraycopy(data,0,temp,0,size);
            data = temp;
        }
    }
}
