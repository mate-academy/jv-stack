package core.stack;

public class MateStack<T> {

    private static final int INITIAL_CAPACITY = 10;
    private int currentCapacity = 10;
    Object[] stack = new Object[INITIAL_CAPACITY];
    private int size = 0;

    public void push(T value) {
        sizeCheck();
        stack[size] = value;
        size++;
    }

    public T peek() {
        if (size == 0) {
            throw new IndexOutOfBoundsException("Stack is empty");
        }
        return (T) stack[size - 1];
    }

    public T pop() {
        if (size == 0) {
            throw new IndexOutOfBoundsException("Stack is empty");
        }
        T oldValue = (T) stack[size - 1];
        stack[size - 1] = null;
        size--;
        return oldValue;
    }

    public int size() {
        return size;
    }

    private void sizeCheck() {
        if (size >= (INITIAL_CAPACITY * 0.75f)) {
            currentCapacity *= 2;
            Object[] newArray = new Object[currentCapacity];
            System.arraycopy(stack, 0,newArray, 0, size);
            stack = newArray;
        }
    }
}
