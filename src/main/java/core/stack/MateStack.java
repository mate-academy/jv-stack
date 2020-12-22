package core.stack;

import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.List;

public class MateStack<T> {
    private List<T> stackList = new LinkedList<>();

    public void push(T value) {
        stackList.add(value);
    }

    public T peek() {
        if (stackList.isEmpty()) {
            throw new EmptyStackException();
        }
        return stackList.get(size() - 1);
    }

    public T pop() {
        if (stackList.isEmpty()) {
            throw new EmptyStackException();
        }
        T removedObject = stackList.get(size() - 1);
        stackList.remove(removedObject);
        return removedObject;
    }

    public int size() {
        return stackList.size();
    }
}
