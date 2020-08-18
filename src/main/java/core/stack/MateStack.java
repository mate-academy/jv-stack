package core.stack;

import java.util.ArrayList;
import java.util.List;

public class MateStack<T> {
    List<T> newArray = new ArrayList<>();

    public void push(T value) {
        newArray.add(value);
    }

    public T peek() {
        try {
            return newArray.get(size() - 1);
        } catch (IndexOutOfBoundsException e) {
            throw new IndexOutOfBoundsException("Stack is empty");
        }
    }

    public T pop() {
        T popElement = peek();
        newArray.remove(size() - 1);
        return popElement;
    }

    public int size() {
        return newArray.size();
    }
}
