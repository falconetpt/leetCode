package exercises.array;

import org.junit.Test;

import static org.junit.Assert.*;

public class MinCostClimbingStairsTest {
  private final MinCostClimbingStairs minCostClimbingStairs = new MinCostClimbingStairs();

  @Test
  public void minCostClimbingStairs_test1() {
    assertEquals(15, minCostClimbingStairs.minCostClimbingStairs(new int[] {10,15,20}));
  }

  @Test
  public void minCostClimbingStairs_test2() {
    assertEquals(6, minCostClimbingStairs.minCostClimbingStairs(new int[] {1,100,1,1,1,100,1,1,100,1}));
  }



}