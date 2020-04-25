package exercises.array;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumSubarrayProductLessThanKTest {
    private NumSubarrayProductLessThanK n;

    @BeforeEach
    void init() {
        n = new NumSubarrayProductLessThanK();
    }

    @Test
    @DisplayName( "Empty list should return 0" )
    void scenario1() {
        int result = n.numSubarrayProductLessThanK( new int[] { }, 12 );
        int expected = 0;

        assertEquals( expected, result );
    }

    @Test
    @DisplayName( "K less than every element in list should return 0" )
    void scenario2() {
        int result = n.numSubarrayProductLessThanK( new int[] { 37 }, 12 );
        int expected = 0;

        assertEquals( expected, result );
    }

    @Test
    @DisplayName( "K equal than single element in list should return 0" )
    void scenario3() {
        int result = n.numSubarrayProductLessThanK( new int[] { 17 }, 17 );
        int expected = 0;

        assertEquals( expected, result );
    }

    @Test
    @DisplayName( "K less than only one element in list should return 1" )
    void scenario4() {
        int result = n.numSubarrayProductLessThanK( new int[] { 7, 37 }, 12 );
        int expected = 1;

        assertEquals( expected, result );
    }

    @Test
    @DisplayName( "Multiple elements combinations - scenario 1" )
    void scenario5() {
        int result = n.numSubarrayProductLessThanK( new int[] { 7, 7, 7 }, 100 );
        int expected = 5;

        assertEquals( expected, result );
    }

    @Test
    @DisplayName( "Multiple elements combinations - scenario 2" )
    void scenario6() {
        int result = n.numSubarrayProductLessThanK( new int[] { 10, 5, 2, 6 }, 100 );
        int expected = 8;

        assertEquals( expected, result );
    }

    @Test
    @DisplayName( "Multiple elements combinations - scenario 3" )
    void scenario7() {
        int result = n.numSubarrayProductLessThanK( new int[] { 10,9,10,4,3,8,3,3,6,2,10,10,9,3 }, 19 );
        int expected = 18;

        assertEquals( expected, result );
    }
}