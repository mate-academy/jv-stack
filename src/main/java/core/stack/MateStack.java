package core.stack;

import java.util.ArrayList;
import java.util.List;

public class MateStack<T> {
    private List<T> stackList;

    public MateStack() {
        stackList = new ArrayList<>();
    }

    public void push(T value) {
        stackList.add(value);
    }

    public T peek() {
        isEmpty(stackList.size());
        return stackList.get(stackList.size() - 1);
    }

    public T pop() {
        isEmpty(stackList.size());
        return stackList.remove(stackList.size() - 1);
    }

    public int size() {
        return stackList.size();
    }

    public void isEmpty(int size) {
        if (size == 0) {
            throw new IndexOutOfBoundsException("Stack is empty");
        }
    }
}
