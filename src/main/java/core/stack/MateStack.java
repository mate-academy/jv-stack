package core.stack;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

public class MateStack<T> {
    int size = 0;
    List<Node> nodes = new ArrayList<>();

    public MateStack() {
    }

    public void push(T value) {
        if (nodes.isEmpty()) {
            nodes.add(new Node(value));
            size++;
        } else {
            Node newNode = new Node(value);
            newNode.next = nodes.get(nodes.size() - 1);
            nodes.add(newNode);
            size++;
        }
    }

    public T peek() {
        T  value = null;
        try {
            value = nodes.get(nodes.size() - 1).value;
        } catch (Exception e) {
            throw new EmptyStackException();
        }
        return value;
    }

    public T pop() {
        T value = null;
        try {
            value = nodes.get(nodes.size() - 1).value;
            nodes.remove(nodes.size() - 1);
            size--;
        } catch (Exception e) {
            throw new EmptyStackException();
        }
        return value;
    }

    public int size() {
        return size;
    }

    public class Node {
        T value;
        Node next;

        public Node(T value) {
            this.value = value;
            this.next = null;
        }
    }
}
