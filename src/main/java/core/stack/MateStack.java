package core.stack;

import java.util.EmptyStackException;

public class MateStack<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] elementData;
    private int size;

    public MateStack() {
        elementData = new Object[DEFAULT_CAPACITY];
    }

    public void push(T value) {
        elementData[size++] = value;
    }

    public T peek() {
        if (size() == 0) {
            throw new EmptyStackException();
        }
        return (T) elementData[size - 1];
    }

    public T pop() {
        T value = peek();
        removeElement(size() - 1);
        return value;
    }

    public int size() {
        return size;
    }

    private void removeElement(int index) {
        if (index >= size || index < 0) {
            throw new ArrayIndexOutOfBoundsException("Index incorrect");
        }
        if (size - index - 1 > 0) {
            System.arraycopy(elementData, index + 1,
                    elementData, index, size - index - 1);
        }
        elementData[size--] = null;
    }
}
