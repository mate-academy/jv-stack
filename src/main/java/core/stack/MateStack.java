package core.stack;

import java.util.EmptyStackException;

public class MateStack<T> {
    private Node<T> top;
    private int size;
    
    public void push(T value) {
        top = new Node<>(value, top);
        size++;
    }
    
    public T peek() {
        checkSize();
        return top.value;
    }
    
    public T pop() {
        checkSize();
        T value = top.value;
        top = top.next;
        size--;
        return value;
    }
    
    public int size() {
        return size;
    }
    
    private void checkSize() {
        if (size == 0) {
            throw new EmptyStackException();
        }
    }
    
    private static class Node<T> {
        T value;
        Node<T> next;
        
        Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }
}
