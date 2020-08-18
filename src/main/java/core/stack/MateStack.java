package core.stack;

import java.util.ArrayList;
import java.util.List;

public class MateStack<T> {
    private int size = 0;
    private List<T> arr = new ArrayList<>();

    public void push(T value) {
        arr.add(size, value);
        size++;
    }

    public T peek() {
        if (size == 0) {
            throw new IndexOutOfBoundsException("Stack is empty");
        }
        return arr.get(size - 1);
    }

    public T pop() {
        if (size == 0) {
            throw new IndexOutOfBoundsException("Stack is empty");
        }
        T value = peek();
        size--;
        return value;
    }

    public int size() {
        return size;
    }
}
