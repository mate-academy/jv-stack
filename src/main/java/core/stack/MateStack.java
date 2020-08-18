package core.stack;

import java.util.Arrays;

public class MateStack<T> {

    private Object[] arr = new Object[0];
    private int size = 0;

    public void push(T value) {
        arr = Arrays.copyOf(arr, ++size);
        arr[size - 1] = value;
    }

    public T peek() {
        isNotEmpty();
        return (T) arr[size - 1];
    }

    public T pop() {
        isNotEmpty();
        T element = (T) arr[size - 1];
        arr = Arrays.copyOf(arr, --size);
        return element;
    }

    public int size() {
        return size;
    }

    private boolean isNotEmpty() {
        if (size == 0) {
            throw new IndexOutOfBoundsException("Stack is empty");
        }
        return true;
    }
}
