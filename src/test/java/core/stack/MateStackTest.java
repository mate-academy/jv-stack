package core.stack;

import org.junit.Before;
import org.junit.Test;
import java.util.EmptyStackException;
import static org.junit.Assert.assertEquals;

public class MateStackTest {
    private MateStack<String> stack;

    @Before
    public void setUp() {
        stack = new MateStack<>();
    }

    @Test
    public void size_emptyStack_ok() {
        assertEquals(0, stack.size());
    }

    @Test
    public void size_oneElement_ok() {
        stack.push("Hello");
        assertEquals(1, stack.size());
    }

    @Test
    public void size_threeElements_ok() {
        stack.push("Hello");
        stack.push("World");
        stack.push("Mate");
        assertEquals(3, stack.size());
    }

    @Test
    public void peek_oneElement_ok() {
        stack.push("Hello");
        assertEquals(1, stack.size());
        String actual = stack.peek();
        String expected = "Hello";
        assertEquals(expected, actual);
        assertEquals(1, stack.size());
    }

    @Test
    public void peek_severalTimes_ok() {
        stack.push("Hello");
        stack.push("World");
        assertEquals(2, stack.size());
        String actual = stack.peek();
        String expected = "World";
        assertEquals(expected, actual);

        String actualSecondTry = stack.peek();
        String expectedSecondTry = "World";
        assertEquals(expectedSecondTry, actualSecondTry);

        String actualThirdTry = stack.peek();
        String expectedThirdTry = "World";
        assertEquals(expectedThirdTry, actualThirdTry);

        assertEquals(2, stack.size());
    }

    @Test(expected = EmptyStackException.class)
    public void peek_emptyStack() {
        assertEquals(0, stack.size());
        stack.peek();
    }

    @Test
    public void pop_ok() {
        stack.push("Hello");
        assertEquals(1, stack.size());
        String actual = stack.pop();
        String expected = "Hello";
        assertEquals(expected, actual);
        assertEquals(0, stack.size());
    }

    @Test
    public void pop_threeElements_ok() {
        stack.push("Hello");
        stack.push("World");
        stack.push("Mate");
        assertEquals(3, stack.size());

        String actual = stack.pop();
        String expected = "Mate";
        assertEquals(expected, actual);
        assertEquals(2, stack.size());

        String actualSecond = stack.pop();
        String expectedSecond = "World";
        assertEquals(expectedSecond, actualSecond);
        assertEquals(1, stack.size());

        String actualThird = stack.pop();
        String expectedThird = "Hello";
        assertEquals(expectedThird, actualThird);
        assertEquals(0, stack.size());
    }


    @Test(expected = EmptyStackException.class)
    public void pop_emptyStack() {
        assertEquals(0, stack.size());
        stack.pop();
    }
}
