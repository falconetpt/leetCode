package exercises.string;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LongestPalindromicSubstringTest {


    @Test
    void longestPalindrome() {
        String result = new LongestPalindromicSubstring().longestPalindrome("babaddtattarrattatddetartrateedredividerb");
        String expected = "ddtattarrattatdd";

        assertEquals(expected, result);
    }
}