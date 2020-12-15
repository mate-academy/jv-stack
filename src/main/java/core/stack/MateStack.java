package core.stack;

public class MateStack<T> {
    private static final int DEFAULT_SIZE = 10;
    private static final byte GROWTH_FACTOR = 2;
    private T[] stack;
    private int size;

    public MateStack() {
        this.stack = (T[]) new Object[DEFAULT_SIZE];
    }

    public void push(T value) {
        if (size == stack.length) {
            grow();
        }
        stack[size++] = value;
    }

    public T peek() {
        return stack[size - 1];
    }

    public T pop() {
        T value = stack[size - 1];
        stack[size-- - 1] = null;
        return value;
    }

    public int size() {
        return size;
    }

    private void grow(){
        T[] newStack = (T[]) new Object[stack.length * GROWTH_FACTOR];
        System.arraycopy(stack, 0, newStack, 0, stack.length);
        stack = newStack;
    }
}
