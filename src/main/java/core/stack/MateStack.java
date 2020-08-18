package core.stack;

import java.util.EmptyStackException;
import java.util.List;
import java.util.ArrayList;

public class MateStack<T> {
    private int size;
    private List<T> elementData;

    public MateStack() {
        size = 0;
        elementData = new ArrayList<>();
    }

    public void push(T value) {
        elementData.add(size, value);
        size++;
    }

    public T peek() {
        if (size == 0)
            throw new IndexOutOfBoundsException("Stack is empty");
        return elementData.get(size - 1);
    }

    public T pop() {
        if (size == 0)
            throw new IndexOutOfBoundsException("Stack is empty");
        T poppedElement = peek();
        size--;
        return poppedElement;
    }

    public int size() {
        return size;
    }
}
