package core.stack;

import java.util.ArrayList;
import java.util.EmptyStackException;

public class MateStack<T> {

    private ArrayList<T> mateStack;

    public MateStack() {
        this.mateStack = new ArrayList<T>();
    }

    public void push(T value) {
        mateStack.add(value);
    }

    public T peek() {
        if (!mateStack.isEmpty()) {
            return mateStack.get(mateStack.size() - 1);
        }
        throw new EmptyStackException();
    }

    public T pop() {
        if (!mateStack.isEmpty()) {
            T value = mateStack.get(mateStack.size() - 1);
            mateStack.remove(mateStack.size() - 1);
            return value;
        }
        throw new EmptyStackException();
    }

    public int size() {
        return mateStack.size();
    }
}