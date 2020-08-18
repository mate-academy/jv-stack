package core.stack;

public class MateStack<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private T[] elements;
    private int size;

    public MateStack() {
        elements = (T[]) new Object[DEFAULT_CAPACITY];
    }

    public void push(T value) {
        if (size + 1 > elements.length) {
            resize();
        }
        elements[size] = value;
        size++;
    }

    public T peek() {
        isEmpty();
        return elements[size - 1];
    }

    public T pop() {
        isEmpty();
        T value = elements[size - 1];
        elements[size - 1] = null;
        size--;
        return value;
    }

    public int size() {
        return size;
    }

    private void resize() {
        T[] newElements = (T[]) new Object[DEFAULT_CAPACITY * 2];
        System.arraycopy(elements, 0, newElements, 0, elements.length);
        elements = newElements;
    }

    private void isEmpty() {
        if (size == 0) {
            throw new IndexOutOfBoundsException("Stack is empty");
        }
    }
}
