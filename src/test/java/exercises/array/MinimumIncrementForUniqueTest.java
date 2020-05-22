package exercises.array;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MinimumIncrementForUniqueTest {
    private MinimumIncrementForUnique m;

    @BeforeEach
    void setUp() {
        m = new MinimumIncrementForUnique();
    }

    @Test
    @DisplayName( "Empty array should return 0" )
    void minIncrementForUnique() {
        int result = m.minIncrementForUnique( new int[] {} );
        int expected = 0;

        assertEquals( expected, result );
    }

    @Test
    @DisplayName( "Single element array should return 0" )
    void minIncrementForSingleElement() {
        int result = m.minIncrementForUnique( new int[] { 1 } );
        int expected = 0;

        assertEquals( expected, result );
    }

    @Test
    @DisplayName( "Sme array with same element repeated once should return 1" )
    void minIncrementForSingleRepeatedElement() {
        int result = m.minIncrementForUnique( new int[] { 1, 1 } );
        int expected = 1;

        assertEquals( expected, result );
    }
}