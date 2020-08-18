package core.stack;

public class MateStack<T> {

    private int size = 10;
    private T[] stackArray;
    private int top;

    public MateStack() {
        this.size = size;
        stackArray = (T[]) new Object[size];
        top = -1;
    }

    public void push(T value) {
        stackArray[++top] = value;
    }

    public T peek() {
        if (top == -1) {
            throw new IndexOutOfBoundsException("Stack is empty");
        }
        return stackArray[top];
    }

    public T pop() {
        if (top == -1) {
            throw new IndexOutOfBoundsException("Stack is empty");
        }
        return stackArray[top--];
    }

    public int size() {
        return (top + 1);
    }
}
