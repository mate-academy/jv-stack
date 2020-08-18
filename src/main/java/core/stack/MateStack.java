package core.stack;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

public class MateStack<T> {
    List<T> stackList;
    private T tail;

    public MateStack() {
        stackList = new ArrayList<>();
    }

    public void push(T value) {
        stackList.add(value);
        tail = value;
    }

    public T peek() {
        indexCheck();
        return stackList.get(stackList.size() - 1);
    }

    public T pop() {
        indexCheck();
        T removed = stackList.get(stackList.size() - 1);
        stackList.remove(stackList.size() - 1);
        return removed;
    }

    public int size() {
        return stackList.size();
    }

    private void indexCheck() {
        if (stackList.size() == 0) {
            throw new IndexOutOfBoundsException("Stack is empty");
        }
        if (tail == null) {
            throw new EmptyStackException();
        }
    }
}
