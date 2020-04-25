package exercises;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FibonaciTest {
    private Fibonaci f = new Fibonaci();

    @Test
    void scenario1() {
        int result = f.fib(2);
        int expected = 1;

        assertEquals(expected, result);
    }

    @Test
    void scenario2() {
        int result = f.fib(4);
        int expected = 3;

        assertEquals(expected, result);
    }
}