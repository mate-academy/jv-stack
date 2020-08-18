package core.stack;

public class MateStack<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private T[] elementData;
    private int size;

    public MateStack() {
        elementData = (T[]) new Object[DEFAULT_CAPACITY];
    }

    public void push(T value) {
        if (size == elementData.length) {
            grow();
        }
        elementData[size++] = value;
    }

    public T peek() {
        if (size == 0) {
            throw new IndexOutOfBoundsException("Stack is empty");
        }
        return elementData[size - 1];
    }

    public T pop() {
        if (size == 0) {
            throw new IndexOutOfBoundsException("Stack is empty");
        }
        T obj;
        int len = size();

        obj = peek();
        removeElementAt(len - 1);

        return obj;
    }

    public int size() {
        return size;
    }

    private void grow() {
        T[] newElementData = (T[]) new Object[elementData.length + (elementData.length >> 1)];
        System.arraycopy(elementData, 0, newElementData, 0, size);
        elementData = newElementData;
    }

    public void removeElementAt(int index) {
        int j = size - index - 1;
        if (j > 0) {
            System.arraycopy(elementData, index + 1, elementData, index, j);
        }
        size--;
        elementData[size] = null;
    }

}
