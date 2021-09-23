package exercises.array;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BreakPalindromeTest {
  private BreakPalindrome breakPalindrome;

  @Before
  public void setUp() throws Exception {
    breakPalindrome = new BreakPalindrome();
  }

  @Test
  public void breakPalindrome1() {
    assertEquals("aaccba", breakPalindrome.breakPalindrome("abccba"));
  }

  @Test
  public void breakPalindrome2() {
    assertEquals("ab", breakPalindrome.breakPalindrome("aa"));
  }
}