package core.stack;

public class MateStack<T> {
    private int size;
    private int stackSize;
    private Object[] array;

    public MateStack() {
        stackSize = 10;
        array = new Object[stackSize];
    }

    public void push(T value) {
        array[++size] = value;
    }

    public T peek() {
        if (size == 0) {
            throw new IndexOutOfBoundsException("Stack is empty");
        }
        return (T) array[size];
    }

    public T pop() {
        if (size == 0) {
            throw new IndexOutOfBoundsException("Stack is empty");
        }
        return (T) array[size--];
    }

    public int size() {
        return size;
    }
}
