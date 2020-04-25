package exercises.array;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BalancedStringTest {
    private BalancedString b;

    @BeforeEach
    void init() {
        b = new BalancedString();
    }

    @Test
    @DisplayName( "Scenario 1 - Test containing all letters once should return 0" )
    void test1() {
        int result = b.balancedString("QWER");
        int expected = 0;

        assertEquals( expected, result );
    }

    @Test
    @DisplayName( "Scenario 2 - Test containing all letters multiple times should return 0" )
    void test2() {
        int result = b.balancedString("QWERQWERQWER");
        int expected = 0;

        assertEquals( expected, result );
    }

    @Test
    @DisplayName( "Scenario 3 - Test missing one letter once should return 1" )
    void test3() {
        int result = b.balancedString("QQWE");
        int expected = 1;

        assertEquals( expected, result );
    }

    @Test
    @DisplayName( "Scenario 4 - Test missing two letters should return 2" )
    void test4() {
        int result = b.balancedString("QQQW");
        int expected = 2;

        assertEquals( expected, result );
    }

    @Test
    @DisplayName( "Scenario 5 - Test missing one letter three times should return 3" )
    void test5() {
        int result = b.balancedString("QQQQ");
        int expected = 3;

        assertEquals( expected, result );
    }

    @Test
    @DisplayName( "Scenario 6 - Test missing multiple letters" )
    void test6() {
        int result = b.balancedString("QQQQQQQQ");
        int expected = 6;

        assertEquals( expected, result );
    }

    @Test
    @DisplayName( "Scenario 7 - Test missing multiple letters" )
    void test7() {
        int result = b.balancedString("EQQQRQQW");
        int expected = 3;

        assertEquals( expected, result );
    }

    @Test
    @DisplayName( "Scenario 8 - Test missing multiple letters" )
    void test8() {
        int result = b.balancedString("WWEQERQWQWWRWWERQWEQ");
        int expected = 3;

        assertEquals( expected, result );
    }
}