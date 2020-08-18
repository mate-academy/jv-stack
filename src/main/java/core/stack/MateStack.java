package core.stack;

public class MateStack<T> {
    private int size;
    private Object[] arrStack = new Object[10];

    public MateStack() {
    }

    public void push(T value) {
        arrStack[++size] = value;
    }

    public T peek() {
        isEmpty();
        T element = (T) arrStack[size];
        return element;
    }

    public T pop() {
        isEmpty();
        T element = (T) arrStack[size];
        size--;
        return element;
    }

    public void isEmpty() {
        if (size == 0) {
            throw new IndexOutOfBoundsException("Stack is empty");
        }
    }

    public int size() {
        return size;
    }
}
