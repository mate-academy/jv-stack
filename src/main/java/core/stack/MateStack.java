package core.stack;

import java.util.ArrayList;
import java.util.List;

public class MateStack<T> {
    private List<T> stackArray = new ArrayList<>();
    private int size;

    public MateStack() {

    }

    public void push(T value) {
        stackArray.add(value);
        size++;
    }

    public T peek() {
        isEmpty();
        return stackArray.get(size - 1);
    }

    public T pop() {
        isEmpty();
        T element = peek();
        size--;
        return element;
    }

    public int size() {
        return size;
    }

    private boolean isEmpty() {
        if (size == 0) {
            throw new IndexOutOfBoundsException("Stack is empty");
        }
        return true;
    }
}
