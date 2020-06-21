package exercises.array;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SubArrDivisibleByTest {
    private SubArrDivisibleBy s = new SubArrDivisibleBy();

    @Test
    @DisplayName( "Null Array should return 0" )
    public void nullScenario() {
        int expected = 0;
        int result = s.subarraysDivByK( null, 0 );

        assertEquals( expected, result );
    }

    @Test
    @DisplayName( "Empty Array should return 0" )
    public void emptyScenario() {
        int expected = 0;
        int result = s.subarraysDivByK( new int[] {}, 0 );

        assertEquals( expected, result );
    }

    @Test
    @DisplayName( "Simple Scenario with no divisor should return 0" )
    public void simpleScenario() {
        int expected = 0;
        int result = s.subarraysDivByK( new int[] {1, 2}, 7 );

        assertEquals( expected, result );
    }

    @Test
    @DisplayName( "Simple Scenario with no divisor should return 6" )
    public void simpleScenario2() {
        int expected = 6;
        int result = s.subarraysDivByK( new int[] {2, 2, 6}, 2 );

        assertEquals( expected, result );
    }

    @Test
    @DisplayName( "Complex Scenario with no divisor should return 6" )
    public void complexScenario() {
        int expected = 7;
        int result = s.subarraysDivByK( new int[] {4,5,0,-2,-3,1}, 5 );

        assertEquals( expected, result );
    }

}