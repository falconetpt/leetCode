package exercises.string;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ZigZagTraversalTest {
  private ZigZagTraversal zigZagTraversal;

  @Before
  public void setUp() throws Exception {
    zigZagTraversal = new ZigZagTraversal();
  }

  @Test
  public void convert() {
    assertEquals("PAHNAPLSIIGYIR", zigZagTraversal.convert("PAYPALISHIRING" , 3));
  }
}