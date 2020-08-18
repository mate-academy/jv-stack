package core.stack;

public class MateStack<T> {
    private static int DEFAULT_CAPACITY = 10;
    private T[] array;
    private int size;
    private int capacity;

    public MateStack() {
        this.array = (T[]) new Object[DEFAULT_CAPACITY];
        capacity = array.length;
    }

    public void push(T value) {
        if (size == capacity - 1) {
            grow();
        }
        array[++size] = value;
    }

    public T peek() {
        if (size > 0) {
            return array[size];
        } else {
            throw new IndexOutOfBoundsException("Stack is empty");
        }
    }

    public T pop() {
        if (size == 0) {
            throw new IndexOutOfBoundsException("Stack is empty");
        }
        return array[size--];
    }

    public int size() {
        return size;
    }

    private void grow() {
        T[] tempArr = array;
        array = (T[]) new Object[(int) (capacity * 1.5)];
        System.arraycopy(tempArr, 0, array, 0, tempArr.length);
    }
}
