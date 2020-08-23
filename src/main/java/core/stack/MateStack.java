package core.stack;

public class MateStack<T> {
    public static final int DEFAULT_CAPACITY = 10;
    private Object[] array;
    private int size;

    public MateStack() {
        array = (T[]) new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    public void push(T value) {
        array[size] = value;
        size++;
    }

    public T peek() {
        if (size == 0) {
            throw new IndexOutOfBoundsException("Stack is empty");
        }
        return (T) array[size - 1];
    }

    public T pop() {
        if (size == 0) {
            throw new IndexOutOfBoundsException("Stack is empty");
        }
        T last = (T) array[size - 1];
        array[--size] = null;
        return last;
    }

    public int size() {
        return size;
    }
}
