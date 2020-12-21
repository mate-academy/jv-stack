package core.stack;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

public class MateStack<T> {
    private List<T> innerArray = new ArrayList<>();

    public void push(T value) {
        innerArray.add(value);
    }

    public T peek() {
        if (size() == 0) {
            throw new EmptyStackException();
        }
        return (innerArray.get(size() - 1));
    }

    public T pop() {
        if (size() == 0) {
            throw new EmptyStackException();
        }
        return innerArray.remove(size() - 1);
    }

    public int size() {
        return innerArray.size();
    }
}
