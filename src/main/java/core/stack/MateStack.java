package core.stack;

public class MateStack<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private T[] stackArray;
    private int size;

    public MateStack() {
        this.stackArray = (T[]) new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }

    public void push(T value) {
        if (size == stackArray.length) {
            stackArray = resize();
        }
        stackArray[size++] = value;
    }

    public T peek() {
        if (size == 0) {
            throw new IndexOutOfBoundsException("Stack is empty");
        }
        return stackArray[size - 1];
    }

    public T pop() {
        if (size == 0) {
            throw new IndexOutOfBoundsException("Stack is empty");
        }
        T object = stackArray[size - 1];
        stackArray[--size] = null;
        return object;
    }

    public int size() {
        return size;
    }

    private T[] resize() {
        T[] temporaryArray = (T[]) new Object[(stackArray.length * 3) / 2];
        System.arraycopy(stackArray, 0, temporaryArray, 0, size);
        return temporaryArray;
    }
}
