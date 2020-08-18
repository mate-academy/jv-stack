package core.stack;

import java.util.ArrayList;
import java.util.List;

public class MateStack<T> {
    private List<T> listStack;

    public MateStack() {
        listStack = new ArrayList<>();
    }

    public void push(T value) {
        listStack.add(value);
    }

    public T peek() {
        isEmpty(listStack.size());
        return listStack.get(listStack.size() - 1);
    }

    public T pop() {
        isEmpty(listStack.size());
        return listStack.remove(listStack.size() - 1);
    }

    public int size() {
        return listStack.size();
    }

    public void isEmpty(int size) {
        if (size == 0) {
            throw new IndexOutOfBoundsException("Stack is empty");
        }
    }
}
