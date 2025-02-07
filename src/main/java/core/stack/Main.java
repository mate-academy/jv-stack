package core.stack;

public class Main {
    public static void main(String[] args) {
        MateStack<String> stack = new MateStack<>();
        for (int i = 1; i <= 50; i++) {
            stack.push(String.valueOf(i));
        }
        System.out.println(stack);
    }
}
