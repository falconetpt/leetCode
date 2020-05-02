package exercises.array;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaxWidthRampTest {
    private MaxWidthRamp m = new MaxWidthRamp();

    @Test
    @DisplayName( "1 - Empty list should return 0" )
    void test1() {
        int result = m.maxWidthRamp( new int[] {} );
        int expected = 0;

        assertEquals( expected, result );
    }

    @Test
    @DisplayName( "2 - Single Element List should return 0" )
    void test2() {
        int result = m.maxWidthRamp( new int[] { 1 } );
        int expected = 0;

        assertEquals( expected, result );
    }

    @Test
    @DisplayName( "3 - Two ascendent element List should return 1" )
    void test3() {
        int result = m.maxWidthRamp( new int[] { 1, 2 } );
        int expected = 1;

        assertEquals( expected, result );
    }

    @Test
    @DisplayName( "4 - Multiple Element List should return correct value" )
    void test4() {
        int result = m.maxWidthRamp( new int[] { 6,0,8,2,1,5 } );
        int expected = 4;

        assertEquals( expected, result );
    }

    @Test
    @DisplayName( "5 - Multiple Element List should return correct value" )
    void test5() {
        int result = m.maxWidthRamp( new int[] { 9,8,1,0,1,9,4,0,4,1 } );
        int expected = 7;

        assertEquals( expected, result );
    }
}