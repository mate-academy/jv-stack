package core.stack;

public class MateStackMain {
    public static void main(String[] args) {
        MateStack<Integer> mateStack = new MateStack<>();
        mateStack.push(10);
        mateStack.push(20);
        mateStack.push(30);

        System.out.println(mateStack.peek());
        System.out.println(mateStack.pop());
    }
}
