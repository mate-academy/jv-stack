package core.stack;

import java.util.ArrayList;
import java.util.List;

public class MateStack<T> {
    private List<T> list = new ArrayList<>();

    public void push(T value) {
        list.add(value);
    }

    public T peek() {
        if (list.size() == 0) {
            throw new IndexOutOfBoundsException("Stack is empty");
        }
        return list.get(list.size() - 1);
    }

    public T pop() {
        if (list.size() == 0) {
            throw new IndexOutOfBoundsException("Stack is empty");
        }
        T value = list.get(list.size() - 1);
        list.remove(list.size() - 1);

        return value;
    }

    public int size() {
        return list.size();
    }
}
