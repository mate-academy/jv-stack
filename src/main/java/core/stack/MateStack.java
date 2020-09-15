package core.stack;

import java.util.ArrayList;
import java.util.List;

public class MateStack<T> {
    private List<T> t;
    private int upperElement;

    public MateStack() {
        t = new ArrayList<>();
        upperElement = -1;
    }

    public void push(T value) {
        t.add(value);
        upperElement++;
    }

    public T peek() {
        if (upperElement == -1) {
            throw new IndexOutOfBoundsException("Stack is empty");
        }
        return t.get(upperElement);
    }

    public T pop() {
        if (upperElement == -1) {
            throw new IndexOutOfBoundsException("Stack is empty");
        }
        T element = t.remove(upperElement);
        upperElement--;
        return element;
    }

    public int size() {
        return t.size();
    }
}
