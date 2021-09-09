package exercises.string;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DecodeStringETest {
  private DecodeStringE decodeString;

  @Before
  public void setUp() throws Exception {
    decodeString = new DecodeStringE();
  }

  @Test
  public void decodeString_simple_returnSimple() {
    assertEquals("xpto", decodeString.decodeString("xpto"));
  }

  @Test
  public void decodeString_returnOne_returnSimple() {
    assertEquals("xpto", decodeString.decodeString("1[xpto]"));
  }

  @Test
  public void decodeString_repeatTwice_returnSimple() {
    assertEquals("xptoxpto", decodeString.decodeString("2[xpto]"));
  }

  @Test
  public void decodeString_repeatThreeTimes_returnSimple() {
    assertEquals("xpxpxp", decodeString.decodeString("3[xp]"));
  }

  @Test
  public void decodeString_repeatThreeTimesTwice_returnSimple() {
    assertEquals("xpxpxpzz", decodeString.decodeString("3[xp]2[z]"));
  }

  @Test
  public void decodeString_repeatTwelveTimesTwice_returnSimple() {
    assertEquals("xpxpxpxpxpxpxpxpxpxpxpxp", decodeString.decodeString("12[xp]"));
  }

  @Test
  public void decodeString_repeat_returnSimple() {
    assertEquals("aaabcbc", decodeString.decodeString("3[a]2[bc]"));
  }

  @Test
  public void decodeString_repeatInsideTimesTwice_returnSimple() {
    assertEquals("xpzzxpzz", decodeString.decodeString("2[xp2[z]]"));
  }

  @Test
  public void decodeString_insane_returnSimple() {
    assertEquals("accaccacc", decodeString.decodeString("3[a2[c]]"));
  }

  @Test
  public void decodeString_insane2_returnSimple() {
    assertEquals("abcabccdcdcdef", decodeString.decodeString("2[abc]3[cd]ef"));
  }

  @Test
  public void decodeString_insane3_returnSimple() {
    assertEquals("abccdcdcdxyz", decodeString.decodeString("abc3[cd]xyz"));
  }
}