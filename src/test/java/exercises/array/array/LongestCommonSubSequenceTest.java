package exercises.array.array;

import org.junit.Test;

import static org.junit.Assert.*;

public class LongestCommonSubSequenceTest {
  @Test
  public void test() {
    final var longest = new LongestCommonSubSequence();
    assertEquals(4, longest.lengthOfLIS(new int[] {0,1,0,3,2,3}));
  }
}