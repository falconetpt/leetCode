package exercises.string;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PermutationInStringTest {
  private PermutationInString permutationInString;

  @Before
  public void setUp() throws Exception {
    permutationInString = new PermutationInString();
  }

  @Test
  public void checkInclusion() {
    assertTrue(permutationInString.checkInclusion("adc", "dcda"));
  }
}