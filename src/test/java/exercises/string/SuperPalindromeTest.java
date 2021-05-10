package exercises.string;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SuperPalindromeTest {
  final SuperPalindrome superPalindrome = new SuperPalindrome();


  @Test
  public void superpalindromesInRange_1() {
    assertEquals(1, superPalindrome.superpalindromesInRange( "0", "0" ) );
  }

  @Test
  public void superpalindromesInRange_2() {
    assertEquals(4, superPalindrome.superpalindromesInRange( "4", "1000" ) );
  }

  @Test
  public void superpalindromesInRange_3() {
    assertEquals(2, superPalindrome.superpalindromesInRange( "40000000000000000", "50000000000000000" ) );
  }
}