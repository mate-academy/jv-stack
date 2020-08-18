package core.stack;

public class MateStack<T> {
    private static final int DEFAULT_SIZE = 10;
    private static final String EMPTY_STACK_MESSAGE = "Stack is empty";
    private int size;
    private T[] data;

    public MateStack() {
        size = 0;
        data = (T[]) new Object[DEFAULT_SIZE];
    }

    public void push(T value) {
        if (size >= data.length) {
            grow();
        }
        data[size] = value;
        size++;
    }

    public T peek() {
        if (size > 0) {
            return data[size - 1];
        }
        throw new IndexOutOfBoundsException(EMPTY_STACK_MESSAGE);
    }

    public T pop() {
        if (size > 0) {
            size--;
            return data[size];
        }
        throw new IndexOutOfBoundsException(EMPTY_STACK_MESSAGE);
    }

    public int size() {
        return size;
    }

    private boolean grow() {
        T[] temp = (T[]) new Object[data.length * 3 / 2];
        System.arraycopy(data, 0, temp, 0, data.length);
        data = temp;
        return true;
    }
}
