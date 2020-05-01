package exercises.number;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BaseNegTwoTest {
    private BaseNegTwo b = new BaseNegTwo();

    @Test
    @DisplayName( "Zero should return 0" )
    void test1() {
        String result = b.baseNeg2( 0 );
        String expected = "0";

        assertEquals( expected, result );
    }

    @Test
    @DisplayName( "One should return 1" )
    void test2() {
        String result = b.baseNeg2( 1 );
        String expected = "1";

        assertEquals( expected, result );
    }

    @Test
    @DisplayName( "Negative Two should return 10" )
    void test3() {
        String result = b.baseNeg2( -2 );
        String expected = "10";

        assertEquals( expected, result );
    }

    @Test
    @DisplayName( "Positive odd number should return right result" )
    void test4() {
        String result = b.baseNeg2( 3 );
        String expected = "111";

        assertEquals( expected, result );
    }

    @Test
    @DisplayName( "Positive even number should return right result" )
    void test5() {
        String result = b.baseNeg2( 2 );
        String expected = "110";

        assertEquals( expected, result );
    }

    @Test
    @DisplayName( "Positive even number should return right result" )
    void test6() {
        String result = b.baseNeg2( 4 );
        String expected = "100";

        assertEquals( expected, result );
    }
}