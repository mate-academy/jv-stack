import core.stack.MateStack;

public class Main {
    public static void main(String[] args) {
        MateStack<Integer> stack = new MateStack<>();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Top value: " + stack.peek());
        System.out.println("Stack size: " + stack.size());

        System.out.println("Popped value: " + stack.pop());
        System.out.println("Stack size after pop: " + stack.size());

        System.out.println("Top value after pop: " + stack.peek());
    }
}
