package core.stack;

import java.util.ArrayList;
import java.util.List;

public class MateStack<T> {
    private List<T> list;

    public MateStack() {
        this.list = new ArrayList<>();
    }

    public void push(T value) {
        list.add(value);
    }

    public T peek() {
        isStackEmpty();
        return list.get(list.size() - 1);
    }

    public T pop() {
        isStackEmpty();
        return list.remove(list.size() - 1);
    }

    public int size() {
        return list.size();
    }

    private void isStackEmpty() {
        if (list.isEmpty()) {
            throw new IndexOutOfBoundsException("Stack is empty");
        }
    }
}
