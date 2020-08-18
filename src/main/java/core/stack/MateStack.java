package core.stack;

import java.util.ArrayList;
import java.util.List;

public class MateStack<T> {
    private int size;
    private List<T> stackArray = new ArrayList<>();

    public void push(T value) {
        stackArray.add(value);
        size++;
    }

    public T peek() {
        sizeCheck();
        return stackArray.get(size - 1);
    }

    public T pop() {
        sizeCheck();
        T value = peek();
        size--;
        return value;
    }

    public int size() {
        return size;
    }

    private void sizeCheck() {
        if (size == 0) {
            throw new IndexOutOfBoundsException("Stack is empty");
        }
    }

}

