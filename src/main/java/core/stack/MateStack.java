package core.stack;

import java.util.EmptyStackException;
import java.util.LinkedList;

public class MateStack<T> {
    private LinkedList<T> elements = new LinkedList<>();

    public void push(T value) {
        elements.addLast(value);
    }

    public T peek() {
        if (elements.isEmpty()) {
            throw new EmptyStackException();
        }
        return elements.getLast();
    }

    public T pop() {
        if (elements.isEmpty()) {
            throw new EmptyStackException();
        }
        return elements.removeLast();
    }

    public int size() {
        return elements.size();
    }
}
