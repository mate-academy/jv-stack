package core.stack;

import java.util.ArrayList;
import java.util.List;

public class MateStack<T> {
    private List<T> stack = new ArrayList<>();
    private int top = -1;

    public void push(T value) {
        stack.add(++top, value);
    }

    public T peek() {
        if (top == -1) {
            throw new IndexOutOfBoundsException("Stack is empty");
        }
        return stack.get(top);
    }

    public T pop() {
        if (top == -1) {
            throw new IndexOutOfBoundsException("Stack is empty");
        }
        return stack.get(top--);
    }

    public int size() {
        return top + 1;
    }
}
