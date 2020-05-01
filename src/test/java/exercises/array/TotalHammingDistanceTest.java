package exercises.array;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TotalHammingDistanceTest {
    private TotalHammingDistance t = new TotalHammingDistance();

    @Test
    @DisplayName( "Empty List Should return zero" )
    void test1() {
        int result = t.totalHammingDistance( new int[] {} );
        int expected = 0;

        assertEquals( expected, result );
    }

    @Test
    @DisplayName( "Single element List Should return zero" )
    void test2() {
        int result = t.totalHammingDistance( new int[] { 1 } );
        int expected = 0;

        assertEquals( expected, result );
    }

    @Test
    @DisplayName( "1 - Single pair element List Should return difference" )
    void test3() {
        int result = t.totalHammingDistance( new int[] { 1, 2} );
        int expected = 2;

        assertEquals( expected, result );
    }

    @Test
    @DisplayName( "2 - Single pair element List Should return difference" )
    void test4() {
        int result = t.totalHammingDistance( new int[] { 1, 4} );
        int expected = 3;

        assertEquals( expected, result );
    }

    @Test
    @DisplayName( "3 - Single pair element List Should return difference" )
    void test5() {
        int result = t.totalHammingDistance( new int[] { 1, 5} );
        int expected = 2;

        assertEquals( expected, result );
    }

    @Test
    @DisplayName( "4 - Single pair element List Should return difference" )
    void test6() {
        int result = t.totalHammingDistance( new int[] { 1, 8} );
        int expected = 4;

        assertEquals( expected, result );
    }

    @Test
    @DisplayName( "5 - Multiple pair element List Should return difference" )
    void test7() {
        int result = t.totalHammingDistance( new int[] { 4, 14, 2 } );
        int expected = 6;

        assertEquals( expected, result );
    }

//    @Test
//    @DisplayName( "6 - Multiple pair element List Should return difference" )
//    void test8() {
//        int result = t.totalHammingDistance( new int[] { 6,1,8,6,8 } );
//        int expected = 22;
//
//        assertEquals( expected, result );
//    }
}