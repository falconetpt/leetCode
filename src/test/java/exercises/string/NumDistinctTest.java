package exercises.string;

import org.junit.Test;

import static org.junit.Assert.*;

public class NumDistinctTest {
  private NumDistincts numDistincts = new NumDistincts();

  @Test
  public void test1() {
    assertEquals(3, numDistincts.numDistinct("rabbbit", "rabbit"));
  }
}