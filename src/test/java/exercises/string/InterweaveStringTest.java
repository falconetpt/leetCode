package exercises.string;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

public class InterweaveStringTest {
  private InterweaveString interweaveString;

  @BeforeEach
  private void setup() {
    interweaveString = new InterweaveString();
  }

  @Test
  void isInterleave_twoStringConcatenationIsBiggerThanResult_returnsFalse() {
    assertFalse(interweaveString.isInterleave("a", "a", "a"));
  }

  @Test
  void isInterleave_emptyStringInputAndOutput_returnsTrue() {
    assertTrue(interweaveString.isInterleave("", "", ""));
  }

  @Test
  void isInterleave_complexInterWeave_returnsTrue() {
    assertTrue(interweaveString.isInterleave("aabcc","dbbca", "aadbbcbcac"));
  }
}