package core.stack;

public class MateStack<T> {
    private static final int CAPACITY = 100;

    private T[] stackStorage;
    private int topIndex = -1;

    public MateStack() {
        this.stackStorage = (T[]) new Object[CAPACITY];
    }

    public void push(T value) {
        stackStorage[++topIndex] = value;
    }

    public T peek() {
        if (topIndex == -1) {
            throw new IndexOutOfBoundsException("Stack is empty");
        }
        return stackStorage[topIndex];
    }

    public T pop() {
        if (topIndex == -1) {
            throw new IndexOutOfBoundsException("Stack is empty");
        }
        return stackStorage[topIndex--];
    }

    public int size() {
        return topIndex + 1;
    }
}
