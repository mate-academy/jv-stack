package core.stack;

public class Main {
    public static void main(String[] args) {
        MateStack<Integer> stack = new MateStack<>();
        stack.push(1);
        stack.push(2);
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.size());
    }
}
