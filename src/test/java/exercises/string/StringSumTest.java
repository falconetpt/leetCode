package exercises.string;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StringSumTest {
  private StringSum stringSum;

  @Before
  public void setUp() throws Exception {
    stringSum = new StringSum();
  }

  @Test
  public void addStrings_sumZero_returnZero() {
    assertEquals("0", stringSum.addStrings("0", "0"));
  }

  @Test
  public void addStrings_sumZeroWithOne_returnOne() {
    assertEquals("1", stringSum.addStrings("1", "0"));
  }
}