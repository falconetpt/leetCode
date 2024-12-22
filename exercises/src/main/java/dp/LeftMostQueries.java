package dp;

import java.util.stream.IntStream;

public class LeftMostQueries {
  public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
    final var result = new int[queries.length];

    for (int i = 0; i < queries.length; i++) {
      final var query = queries[i];
      final var aValue = heights[query[0]];
      final var bValue = heights[query[1]];
      final var maxToLookFor = Math.max(aValue, bValue);
      final var index = IntStream.range(Math.max(query[0], query[1]), heights.length)
          .filter(i -> heights[i] >= maxToLookFor)
          .findFirst()
          .orElse(-1);
      result[i] = index;
    }

    return result;
  }
}
