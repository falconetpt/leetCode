package exercises.array;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LonguestIncreasingPathTest {
    LonguestIncreasingPath l = new LonguestIncreasingPath();

    @Test
    @DisplayName( "Scenario 1 - null array should return 0")
    void nullScenario() {
        int result = l.longestIncreasingPath( null );
        int expected = 0;

        assertEquals( expected, result );
    }


    @Test
    @DisplayName( "Scenario 2 - empty array should return 0")
    void emptyScenario() {
        int result = l.longestIncreasingPath( new int[][]{} );
        int expected = 0;

        assertEquals( expected, result );
    }

    @Test
    @DisplayName( "Scenario 3 - single element array should return 1")
    void singleElement() {
        int result = l.longestIncreasingPath( new int[][]{ {1} } );
        int expected = 1;

        assertEquals( expected, result );
    }

    @Test
    @DisplayName( "Scenario 4 - multiple element array should return 4 when there is 4 elements increasing")
    void complexExample1() {
        int result = l.longestIncreasingPath( new int[][]{
                {9, 9, 4 },
                {6, 6, 8},
                {2, 1, 1}
        } );
        int expected = 4;

        assertEquals( expected, result );
    }

    @Test
    @DisplayName( "Scenario 5 - multiple element array should return 4 when there is 4 elements increasing")
    void complexExample2() {
        int result = l.longestIncreasingPath( new int[][]{
                {3, 4, 5},
                {3, 2, 6},
                {2, 2, 1}
        } );
        int expected = 4;

        assertEquals( expected, result );
    }
}