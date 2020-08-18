package core.stack;

public class MateStack<T> {

    private Entry<T> first;
    private int size;

    public void push(T value) {
        Entry<T> newEntry = new Entry<>(value);
        if (first == null) {
            first = newEntry;
        }
        newEntry.next = first;
        first = newEntry;
        ++size;
    }

    public T peek() {
        if (size == 0) {
            throw new IndexOutOfBoundsException("Stack is empty");
        }
        return first.value;
    }

    public T pop() {
        if (size == 0) {
            throw new IndexOutOfBoundsException("Stack is empty");
        }
        T element = first.value;
        first = first.next;
        --size;
        return element;
    }

    public int size() {
        return size;
    }

    private static class Entry<T> {
        private T value;
        private Entry<T> next;

        private Entry(T value) {
            this.value = value;
        }
    }
}
