package core.stack;

public class MateStack<T> {
    private static final int START_CAPACITY = 10;
    private int size;
    private Object[] elements;

    public MateStack() {
        this.elements = new Object[START_CAPACITY];
    }

    public void push(T value) {
        if (size == elements.length) {
            grow();
        }
        elements[size] = value;
        size++;
    }

    public T peek() {
        if (size == 0) {
            throw new IndexOutOfBoundsException("Stack is empty");
        }
        return (T) elements[size - 1];
    }

    public T pop() {
        if (size == 0) {
            throw new IndexOutOfBoundsException("Stack is empty");
        }
        T element = (T) elements[size - 1];
        removeLastElement();
        return element;
    }

    public int size() {
        return size;
    }

    private Object[] grow() {
        int newCapacity = size * 2;
        Object[] grownElements = new Object[newCapacity];
        System.arraycopy(elements, 0, grownElements, 0, size);
        return grownElements;
    }

    public void removeLastElement() {
        size = size - 1;
        System.arraycopy(elements, 0, elements, 0, size);
    }
}
