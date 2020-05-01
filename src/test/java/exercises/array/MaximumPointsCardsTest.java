package exercises.array;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaximumPointsCardsTest {
    private MaximumPointsCards m = new MaximumPointsCards();

    @Test
    @DisplayName( "1 - Multiple elements" )
    void test1() {
        int result = m.maxScore( new int[] { 1, 2, 3, 4, 5, 6, 1 }, 3);
        int expected = 12;

        assertEquals( expected, result );
    }

    @Test
    @DisplayName( "2 - Multiple elements" )
    void test2() {
        int result = m.maxScore( new int[] { 2,2,2 }, 2);
        int expected = 4;

        assertEquals( expected, result );
    }

    @Test
    @DisplayName( "3 - Multiple elements" )
    void test3() {
        int result = m.maxScore( new int[] { 9,7,7,9,7,7,9 }, 7);
        int expected = 55;

        assertEquals( expected, result );
    }

    @Test
    @DisplayName( "4 - Multiple elements" )
    void test4() {
        int result = m.maxScore( new int[] { 1,79,80,1,1,1,200,1 }, 3);
        int expected = 202;

        assertEquals( expected, result );
    }

    @Test
    @DisplayName( "5 - Multiple elements" )
    void test5() {
        int result = m.maxScore( new int[] { 1,1000,1 }, 1);
        int expected = 1;

        assertEquals( expected, result );
    }

    @Test
    @DisplayName( "5 - Multiple elements" )
    void test6() {
        int result = m.maxScore( new int[] { 100,40,17,9,73,75 }, 3);
        int expected = 248;

        assertEquals( expected, result );
    }


}