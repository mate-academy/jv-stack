package core.stack;

import java.util.ArrayList;
import java.util.List;

public class MateStack<T> {
    private List<T> stackArray = new ArrayList<>();
    private int size = 0;

    public void push(T value) {
        stackArray.add(size, value);
        size++;
    }

    public T peek() {
        if (size == 0) {
            throw new IndexOutOfBoundsException("Stack is empty");
        }
        return stackArray.get(size - 1);
    }

    public T pop() {
        if (size == 0) {
            throw new IndexOutOfBoundsException("Stack is empty");
        }
        T item = peek();
        size--;
        return item;
    }

    public int size() {
        return size;
    }
}
