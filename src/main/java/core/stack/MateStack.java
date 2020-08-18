package core.stack;

import java.util.ArrayList;
import java.util.List;

public class MateStack<T> {
    private List<T> stackStorage;
    private int topIndex = -1;

    public MateStack() {
        this.stackStorage = new ArrayList<>();
    }

    public void push(T value) {
        stackStorage.add(value);
        topIndex++;
    }

    public T peek() {
        if (stackStorage.size() == 0) {
            throw new IndexOutOfBoundsException("Stack is empty");
        }
        return stackStorage.get(topIndex);
    }

    public T pop() {
        if (stackStorage.size() == 0) {
            throw new IndexOutOfBoundsException("Stack is empty");
        }
        return stackStorage.remove(topIndex--);
    }

    public int size() {
        return stackStorage.size();
    }
}
