package exercises.array;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class CountBitsTest {
    private CountBits c = new CountBits();

    @Test
    @DisplayName( "0 should return array with zero" )
    void test1() {
        int[] result = c.countBits( 0 );
        int[] expected = new int[] { 0 };

        assertArrayEquals( expected, result );
    }

    @Test
    @DisplayName( "1 should return array with zero, and one" )
    void test2() {
        int[] result = c.countBits( 1 );
        int[] expected = new int[] { 0, 1 };

        assertArrayEquals( expected, result );
    }

    @Test
    @DisplayName( "2 should return array with zero, and one 2 times" )
    void test3() {
        int[] result = c.countBits( 2 );
        int[] expected = new int[] { 0, 1, 1 };

        assertArrayEquals( expected, result );
    }

    @Test
    @DisplayName( "5 should return multiple array" )
    void test4() {
        int[] result = c.countBits( 5 );
        int[] expected = new int[] { 0,1,1,2,1,2 };

        assertArrayEquals( expected, result );
    }
}