package core.stack;

import java.util.EmptyStackException;

public class MateStack<T> {
    public static final int LENGTH = 10;
    public static final double MULTIPLIER = 1.5;
    private T[] array;
    private int size;

    public MateStack() {
        array = (T[]) new Object[LENGTH];
    }

    public void push(T value) {
        if (size == array.length) {
            resize();
        }
        array[size++] = value;
    }

    public T peek() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        return array[size - 1];
    }

    public T pop() {
        T request = peek();
        array[--size] = null;
        return request;
    }

    public int size() {
        return size;
    }

    private void resize() {
        T[] array = (T[]) new Object[(int) (size * MULTIPLIER)];
        System.arraycopy(this.array, 0, array, 0, size);
        this.array = array;
    }
}
