package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class DistanceAfterXQueries {

  public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
    final var dp = new int[n + 1];
    final var result = new int[queries.length];
    final var seenLast = new HashMap<Integer, List<Integer>>();

    for (int i = 0; i < n; i++) {
      dp[i] = n - i - 1;
    }

    for (int i = 0; i < queries.length; i++) {
      final var element = queries[i];
      final var origin = element[0];
      final var destination = element[1];

      // System.out.println("Start");
      // System.out.println(Arrays.toString(dp));

      dp[origin] = Math.min(dp[origin], dp[destination] + 1);

      seenLast.putIfAbsent(destination, new ArrayList<>());
      seenLast.get(destination).add(origin);

      seenLast.getOrDefault(origin, List.of())
          .forEach(index -> dp[index] = Math.min(dp[index], dp[origin] + 1));

      for (int j = origin - 1; j >= 0; j--) {
        final var fj = j;
        dp[j] = Math.min(dp[j], dp[j + 1] + 1);

        seenLast.getOrDefault(j, List.of()).stream()
            // .peek(index -> System.out.println("dp: " + dp[fj] + ": index :" + index + ", dp[index]" + dp[index] + ", " + dp[fj]))
            .forEach(index -> dp[index] = Math.min(dp[fj] + 1, dp[index]));
      }

      // System.out.println(Arrays.toString(dp));
      // System.out.println("------");



      result[i] = dp[0];
    }

    return result;
  }
}
