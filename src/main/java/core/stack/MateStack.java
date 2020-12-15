package core.stack;

public class MateStack<T> {
    private static final int DEFAULT_SIZE = 10;
    private T[] stack;
    private int size;

    public MateStack() {
        this.stack = (T[]) new Object[DEFAULT_SIZE];
    }

    public void push(T value) {
        if (size == stack.length) {
            grow();
        }
        stack[size] = value;
    }

    public T peek() {
        return stack[size - 1];
    }

    public T pop() {
        return null;
    }

    public int size() {
        return 0;
    }

    private void grow(){}
}
