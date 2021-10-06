package exercises.array;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RemoveBoxesTest {
  private RemoveBoxes removeBoxes;

  @Before
  public void setUp() throws Exception {
    removeBoxes = new RemoveBoxes();
  }

  @Test
  public void removeBoxes_emptyArray_returns0() {
    assertEquals(0, removeBoxes.removeBoxes(new int[] {} ));
  }

  @Test
  public void removeBoxes_singleElementArray_returns1() {
    assertEquals(1, removeBoxes.removeBoxes(new int[] { 1 } ));
  }

  @Test
  public void removeBoxes_sameElementTwiceElementArray_returns1() {
    assertEquals(4, removeBoxes.removeBoxes(new int[] { 1, 1 } ));
  }

  @Test
  public void removeBoxes_sameElementThreeTimesElementArray_returns1() {
    assertEquals(9, removeBoxes.removeBoxes(new int[] { 1, 1, 1 } ));
  }
}