package core.stack;

import java.util.EmptyStackException;

public class MateStack<T> {
    MyNode<T> first;
    MyNode<T> last;
    int size;

    MateStack() {
        size = 0;
    }

    public void push(T value) {
        MyNode<T> currentNode = new MyNode<>();
        if (size == 0) {
            first = currentNode;
            last = currentNode;
            currentNode.next = null;
        } else {
            currentNode.next = first;
            first = currentNode;
        }
        currentNode.value = value;
        size++;
    }

    public T peek() {
        checkStack();
        return first.value;
    }

    public T pop() {
        checkStack();
        T memValue = first.value;
        first = first.next;
        size--;
        return memValue;
    }

    public int size() {
        return size;
    }

    private void checkStack() {
        if (size == 0) {
            throw new EmptyStackException();
        }
    }
}
