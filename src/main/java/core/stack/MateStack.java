package core.stack;

import java.util.EmptyStackException;

public class MateStack<T> {
    private static final int EMPTY_STACK_SIZE = 0;
    private static final int STACK_ENLARGEMENT = 1;
    private static final int STACK_DECREMENT = -1;
    private T[] mateStack;

    public MateStack() {
        this.mateStack = (T[]) new Object[EMPTY_STACK_SIZE];
    }

    public void push(T value) {
        changeStackSize(STACK_ENLARGEMENT);
        mateStack[mateStack.length - 1] = value;
    }

    public T peek() {
        if (mateStack.length > EMPTY_STACK_SIZE) {
            return mateStack[mateStack.length - 1];
        }
        throw new EmptyStackException();
    }

    public T pop() {
        T value = peek();
        changeStackSize(STACK_DECREMENT);
        return value;
    }

    public int size() {
        return mateStack.length;
    }

    private void changeStackSize(int value) {
        int capacity = mateStack.length;
        int newCapacity = capacity + value;

        if (newCapacity == EMPTY_STACK_SIZE) {
            mateStack = (T[]) new Object[EMPTY_STACK_SIZE];
            return;
        }
        T[] tempStack = (T[]) new Object[newCapacity];
        if (newCapacity > capacity) {
            System.arraycopy(mateStack, 0, tempStack, 0, capacity);
        }
        if (newCapacity < capacity) {
            System.arraycopy(mateStack, 0, tempStack, 0, capacity - 1);
        }
        mateStack = tempStack;
        tempStack = null;
    }
}
