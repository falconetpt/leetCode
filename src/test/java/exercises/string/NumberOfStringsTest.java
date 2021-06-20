package exercises.string;

import org.junit.Test;

import static org.junit.Assert.*;

public class NumberOfStringsTest {

  @Test
  public void test1() {
    assertEquals(1, new NumberOfStrings().numberOfSubstrings("abc"));
    assertEquals(3, new NumberOfStrings().numberOfSubstrings("aaacb"));
    assertEquals(10, new NumberOfStrings().numberOfSubstrings("abcabc"));
  }
}