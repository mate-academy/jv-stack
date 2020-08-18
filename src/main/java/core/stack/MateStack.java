package core.stack;

import java.util.LinkedList;

public class MateStack<T> {
    private LinkedList list = new LinkedList();

    public void push(T value) {
        list.add(value);
    }

    public T peek() {
        check();
        return (T) list.getLast();
    }

    public T pop() {
        check();
        T toReturn = (T) list.getLast();
        list.removeLast();
        return toReturn;
    }

    public int size() {
        return list.size();
    }

    private void check() {
        if (size() == 0) {
            throw new IndexOutOfBoundsException("Stack is empty");
        }
    }
}
