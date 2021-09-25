package exercises.array;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ShortestPathTest {
  private ShortestPath shortestPath;

  @Before
  public void setUp() {
    shortestPath = new ShortestPath();
  }

  @Test
  public void shortestPath_1() {
    final var grid = new int[][] {
      new int[]{0, 0},
      new int[]{0, 0}
    };

    assertEquals(2, shortestPath.shortestPath(grid, 0));
  }

  @Test
  public void shortestPath_2() {
    final var grid = new int[][] {
      new int[]{0, 1},
      new int[]{0, 0}
    };

    assertEquals(2, shortestPath.shortestPath(grid, 0));
  }

  @Test
  public void shortestPath_3() {
    final var grid = new int[][] {
      new int[]{0, 1},
      new int[]{1, 0}
    };

    assertEquals(-1, shortestPath.shortestPath(grid, 0));
  }

  @Test
  public void shortestPath_4() {
    final var grid = new int[][] {
      new int[]{0,1,1},
      new int[]{1,1,1},
      new int[]{1,0,0}
    };

    assertEquals(-1, shortestPath.shortestPath(grid, 1));
  }
}