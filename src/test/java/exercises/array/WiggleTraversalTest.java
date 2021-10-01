package exercises.array;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class WiggleTraversalTest {
  private WiggleTraversal wiggleTraversal;

  @Before
  public void setUp() throws Exception {
    wiggleTraversal = new WiggleTraversal();
  }

  @Test
  public void wiggleMaxLength() {
    assertEquals(6, wiggleTraversal.wiggleMaxLength(new int[]{ 1,7,4,9,2,5 }));
  }
}