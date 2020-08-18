package core.stack;

import java.util.ArrayList;
import java.util.List;

public class MateStack<T> {
    private int head;
    private List<T> list = new ArrayList<>();

    public void push(T value) {
        list.add(value);
        head = list.size() - 1;
    }

    public T peek() {
        if (size() == 0) {
            throw new IndexOutOfBoundsException("Stack is empty");
        }
        return list.get(head);
    }

    public T pop() {
        if (size() == 0) {
            throw new IndexOutOfBoundsException("Stack is empty");
        }
        T removedValue = list.get(head);
        list.remove(head);
        head--;
        return removedValue;
    }

    public int size() {
        return list.size();
    }
}
