package core.stack;

public class MateStack<T> {

    private static final int MAX_SIZE = 50;
    private T[] stackArray;
    private int counter;

    public MateStack() {
        stackArray = (T[]) new Object[MAX_SIZE];
        counter = -1;
    }

    public void push(T value) {
        stackArray[++counter] = value;
    }

    public T peek() {
        if (counter == -1) {
            throw new IndexOutOfBoundsException("Stack is empty");
        }
        return stackArray[counter];
    }

    public T pop() {
        if (counter == -1) {
            throw new IndexOutOfBoundsException("Stack is empty");
        }
        return stackArray[counter--];
    }

    public int size() {
        return counter + 1;
    }
}
