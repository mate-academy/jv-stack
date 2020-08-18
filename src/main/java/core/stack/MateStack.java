package core.stack;

public class MateStack<T> {
    private Entry<T> tail;
    private int size;

    public void push(T value) {
        Entry<T> currentEntry = new Entry<>(value, null, null);
        if (size != 0) {
            Entry<T> prevEntry = tail;
            prevEntry.next = currentEntry;
            currentEntry.prev = prevEntry;
        }
        tail = currentEntry;
        size++;
    }

    public T peek() {
        if (size == 0) {
            throw new IndexOutOfBoundsException("Stack is empty");
        }
        return tail.value;
    }

    public T pop() {
        if (size == 0) {
            throw new IndexOutOfBoundsException("Stack is empty");
        }
        Entry<T> entry = tail;
        unlink(entry);
        return entry.value;
    }

    private void unlink(Entry<T> entry) {
        Entry<T> entryPrevious = entry.prev;
        if (entryPrevious != null) {
            entryPrevious.next = entry.next;
        }

        Entry<T> entryNext = entry.next;
        if (entryNext != null) {
            entryNext.prev = entry.prev;
        } else {
            tail = entry.prev;
        }
        size--;
    }

    public int size() {
        return size;
    }

    private static class Entry<T> {
        T value;
        Entry<T> next;
        Entry<T> prev;

        Entry(T value, Entry<T> next, Entry<T> prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }
}
