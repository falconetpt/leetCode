package exercises.array;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaximalSquareTest {
    private MaximalSquare m;

    @BeforeEach
    void setUp() {
        m = new MaximalSquare();
    }

    @Test
    void maximalSquare() {
        int result = m.maximalSquare( new char[][] {} );
        int expected = 0;

        assertEquals( expected, result );
    }
}