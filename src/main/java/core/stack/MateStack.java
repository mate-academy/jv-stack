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
        if (list.isEmpty()) {
            throw new IndexOutOfBoundsException("Stack is empty");
        }
        return list.get(list.size() - 1);
    }

    public T pop() {
        if (list.isEmpty()) {
            throw new IndexOutOfBoundsException("Stack is empty");
        }
        return list.remove(list.size() - 1);
    }

    public int size() {
        return list.size();
    }
}
