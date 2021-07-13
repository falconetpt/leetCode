package exercises.array;

import org.junit.Test;

import static org.junit.Assert.*;

public class MaxChunksTest {
  @Test
  public void x() {
    assertEquals(4, new MaxChunks().maxChunksToSorted(new int[]{1,0,2,3,4}));
    assertEquals(1, new MaxChunks().maxChunksToSorted(new int[]{4,3,2,1,0}));
    assertEquals(2, new MaxChunks().maxChunksToSorted(new int[]{0,1}));
  }
}
