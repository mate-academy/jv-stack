package core.stack;

import java.util.Arrays;
import java.util.EmptyStackException;

public class MateStack<T> {

    private int size = 0;
    private int index = 0;
    private Object[] array = new Object[10];

    public void push(T value) {
        ensureCapacity();
        size++;
        array[index] = value;
        index++;
    }

    public T peek() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        T peekElement = (T) array[index - 1];
        return peekElement;
    }

    public T pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        T returnElement = (T) array[index - 1];
        array[index--] = null;
        size--;
        return returnElement;
    }

    public int size() {
        return size;
    }

    private void ensureCapacity() {
        if (index == array.length) {
            array = Arrays.copyOf(array, array.length << 1);
        }
    }
}
