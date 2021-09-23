package exercises.array;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UniquePathsWithObstaclesTest {
  private UniquePathsWithObstacles uniquePathObstacles;

  @Before
  public void setUp() throws Exception {
    uniquePathObstacles = new UniquePathsWithObstacles();
  }

  @Test
  public void uniquePathsWithObstacles() {
    uniquePathObstacles.uniquePathsWithObstacles(new int[][]{
      new int[] {0,0,0},
      {0,1,0},
      {0,0,0}
    });
  }
}