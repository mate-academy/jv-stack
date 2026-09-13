package core.stack;

import java.util.EmptyStackException;
import java.util.LinkedList;

public class MateStack<T> {
    private LinkedList<T> stack = new LinkedList<>();

    public void push(T value) {
        stack.add(value);
    }

    public T peek() {
        validateNotEmpty();
        return stack.getLast();
    }

    public T pop() {
        validateNotEmpty();
        return stack.removeLast();
    }

    public int size() {
        return stack.size();
    }

    private void validateNotEmpty() {
        if (stack.isEmpty()) {
            throw new EmptyStackException();
        }
    }
}
