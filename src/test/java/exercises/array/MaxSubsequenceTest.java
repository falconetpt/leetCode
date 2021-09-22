package exercises.array;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class MaxSubsequenceTest {
  private MaxSubsequence maxSubsequence;

  @Before
  public void setUp() throws Exception {
    maxSubsequence = new MaxSubsequence();
  }

  @Test
  public void maxLength_emptyList_returns0() {
    assertEquals(0, maxSubsequence.maxLength(List.of()));
  }

  @Test
  public void maxLength_emptyElement_returns0() {
    assertEquals(0, maxSubsequence.maxLength(List.of("")));
  }

  @Test
  public void maxLength_singleElement_returns1() {
    assertEquals(1, maxSubsequence.maxLength(List.of("a")));
  }

  @Test
  public void maxLength_twoDistinctElements_returns2() {
    assertEquals(2, maxSubsequence.maxLength(List.of("a", "b")));
  }

  @Test
  public void maxLength_twoSameElement_returns1() {
    assertEquals(1, maxSubsequence.maxLength(List.of("a", "a")));
  }

  @Test
  public void maxLength_multipleElementsWithRepeatChar_returns2() {
    assertEquals(2, maxSubsequence.maxLength(List.of("ab", "ac", "ad")));
  }
}