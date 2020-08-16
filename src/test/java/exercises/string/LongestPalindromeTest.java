package exercises.string;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LongestPalindromeTest {
    private LongestPalindrome l = new LongestPalindrome();

    @Test
    @DisplayName( "Empty String should return 0" )
    void longestPalindrome1() {
        int result = l.longestPalindrome( "" );
        assertEquals(0, result );
    }

    @Test
    @DisplayName( "Null String should return 0" )
    void longestPalindrome2() {
        int result = l.longestPalindrome( null );
        assertEquals(0, result );
    }

    @Test
    @DisplayName( "Single element String should return 1" )
    void longestPalindrome3() {
        int result = l.longestPalindrome( "a" );
        assertEquals(1, result );
    }

    @Test
    @DisplayName( "Multiple element String should return 7" )
    void longestPalindrome4() {
        int result = l.longestPalindrome( "abccccdd" );
        assertEquals(7, result );
    }
}