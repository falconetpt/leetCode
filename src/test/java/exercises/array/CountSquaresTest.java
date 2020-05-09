package exercises.array;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CountSquaresTest {
    private CountSquares c;

    @BeforeEach
    void setUp() {
        c = new CountSquares();
    }

    @Test
    void countSquares() {
        int result = c.countSquares( new int[][]{
                {0,1,1,1},
                {1,1,1,1},
                {0,1,1,1}
        } );
        int expected = 15;

        assertEquals( expected, result );
    }
}