package exercises.array;

import java.util.Arrays;

public class MinCostClimbingStairs {
  public int minCostClimbingStairs(int[] cost) {
    final var minCost = new int[cost.length];
    Arrays.fill(minCost, Integer.MAX_VALUE);

    minCostClimbingStairs(cost, 0, minCost);
    minCostClimbingStairs(cost, 1, minCost);

    return Math.min(minCost[0], minCost[1]);
  }

  private int minCostClimbingStairs(final int[] cost, final int i, final int[] minCost) {
    if (i >= cost.length) {
      return 0;
    } else if (minCost[i] < Integer.MAX_VALUE) {
      return minCost[i];
    } else {
      final var oneStepValue = cost[i] + minCostClimbingStairs(cost, i + 1, minCost);
      final var twoStepValue = cost[i] + minCostClimbingStairs(cost, i + 2, minCost);

      minCost[i] = Math.min(oneStepValue, twoStepValue);

      return minCost[i];
    }
  }
}
