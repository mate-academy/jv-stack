package core.stack;

import java.util.EmptyStackException;
import java.util.Objects;

public class MateStack<T> {
    private static final int INITIAL_CAPACITY = 10;
    private static final int INCREASES_INDEX = 2;
    private Node[] elementData;
    private int size;

    public MateStack() {
        size = 0;
        elementData = new Node[INITIAL_CAPACITY];
    }

    public void push(T value) {
        checkSize();
        Node<T> pushNode = new Node<>();
        pushNode.setItem(value);
        elementData[size] = pushNode;
        size++;
    }

    private void checkSize() {
        if (size == elementData.length) {
            Node[] tempArray = new Node[size + size / INCREASES_INDEX];
            System.arraycopy(elementData, 0, tempArray, 0, elementData.length);
            elementData = tempArray;
        }
    }

    public T peek() {
        checkEmptyArray();
        return (T) elementData[size - 1].item;
    }

    public T pop() {
        checkEmptyArray();
        T nodeToRemove = (T) elementData[size - 1].item;
        elementData[size - 1] = null;
        size--;
        return nodeToRemove;
    }

    private void checkEmptyArray() {
        if (size == 0) {
            throw new EmptyStackException();
        }
    }

    public int size() {
        return size;
    }

    static class Node<T> {
        private T item;

        public void setItem(T item) {
            this.item = item;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }

            Node<?> node = (Node<?>) o;

            return Objects.equals(item, node.item);
        }

        @Override
        public int hashCode() {
            return item != null ? item.hashCode() : 0;
        }
    }
}
