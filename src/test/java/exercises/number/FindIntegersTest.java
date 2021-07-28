package exercises.number;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FindIntegersTest {
  private FindIntegers findIntegers;

  @Before
  public void setUp() throws Exception {
    findIntegers = new FindIntegers();
  }

  @Test
  public void findIntegers() {
    assertEquals(5, findIntegers.findIntegers(5));
  }
}