package core.stack;

import java.util.Arrays;

public class MateStack<T> {

    private int elementCount = 0;
    private Object[] elementData = new Object[elementCount];

    public void push(T value) {
        if (elementCount == elementData.length) {
            elementData = Arrays.copyOf(elementData, elementData.length + 1);
        }
        elementData[elementCount] = value;
        elementCount = elementCount + 1;
    }

    public T peek() {
        if (elementCount == 0) {
            throw new IndexOutOfBoundsException("Stack is empty");
        }
        return (T) elementData[elementCount - 1];
    }

    public T pop() {
        T obj;
        int len = size();
        obj = peek();
        removeElementAt(len - 1);
        return obj;
    }

    public int size() {
        return elementCount;
    }

    private void removeElementAt(int index) {
        if (index >= elementCount) {
            throw new ArrayIndexOutOfBoundsException(index + " >= "
                    + elementCount);
        } else if (index < 0) {
            throw new ArrayIndexOutOfBoundsException(index);
        }

        int j = elementCount - index - 1;
        if (j > 0) {
            System.arraycopy(elementData, index + 1, elementData, index, j);
        }
        elementCount--;
        elementData[elementCount] = null;
    }
}
