package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CombinationSum {
  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    final var dp = new Set[target + 1];
    dp[0] = new HashSet<List<Integer>>();
    dp[0].add(List.of());

    // System.out.println(Arrays.toString(dp));

    for (int i = 1; i <= target; i++) {
      for (final var candidate : candidates) {
        final var index = i - candidate;
        // System.out.println("index =" + index);
        if (index < 0) continue;
        if (dp[index] == null) continue;
        if(dp[i] == null) dp[i] = new HashSet<List<Integer>>();
        final var element = (Set<List<Integer>>) dp[index];
        final var sums = element.stream()
            .map(e -> {
              final var result = new ArrayList<Integer>(e);
              result.add(candidate);
              return result;
            }).toList();
        sums.forEach(dp[i]::add);

//                     System.out.println("========");
//                     System.out.println("element: " + element.size());

//           System.out.println(sums);
//           System.out.println(Arrays.toString(dp));
//                     System.out.println("========");

      }
    }

    final var result = (Set<List<Integer>>) dp[target];
    if (result == null) return List.of();
    final var uniqueList = result.stream().peek(Collections::sort).collect(Collectors.toSet());

    return new ArrayList<>(uniqueList);
  }
}
