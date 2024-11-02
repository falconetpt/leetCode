package exercises.u.exercises;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TowerHeightsTest {
  private TowerHeights towerHeights;

  @Before
  public void setUp() {
    towerHeights = new TowerHeights();
  }

  @Test
  public void maxJump() {
    final var input = new int[][] {
        {60,60,40},
        {50, 40, 45},
        {15, 10, 10}
    };

    final var maxJump = towerHeights.maxJump(input);

    assertEquals(4, maxJump);
  }
}