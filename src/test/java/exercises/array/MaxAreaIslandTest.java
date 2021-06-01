package exercises.array;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MaxAreaIslandTest {

  @Test
  public void test1() {
    final var islandCalculator = new MaxAreaIsland();
    final var island = new int[][]{
      {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
      {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
      {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
      {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
      {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
      {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
      {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
      {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}
    };

    assertEquals(6, islandCalculator.maxAreaOfIsland(island));
  }

  @Test
  public void test2() {
    final var islandCalculator = new MaxAreaIsland();
    final var island = new int[][]{
      {1,1,0,0,0},
      {1,1,0,0,0},
      {0,0,0,1,1},
      {0,0,0,1,1},
    };

    assertEquals(4, islandCalculator.maxAreaOfIsland(island));
  }

}