package exercises.blind;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CombinationSum {
  public List<List<Integer>> combinationSum(final int[] candidates, final int target) {
    final var result = new HashSet<List<Integer>>();
    Arrays.sort(candidates);
    final List<List<Integer>>[] dp = new List[target + 1];
    Arrays.setAll(dp, element -> new ArrayList<>());
    dp[0].add(List.of());

    for (int i = 0; i < candidates.length; i++) {
      final var element = candidates[i];
      for (int j = 1; j <= target / element; j++) {
        final var list = IntStream.range(0, j).mapToObj(e -> element)
          .collect(Collectors.toList());
        dp[element * j].add(list);
      }
    }

    for (int i = 0; i <= target / 2; i++) {
      final var start = dp[i];
      final var end = dp[target - i];

      for (final var listOne : start) {
        for (final var listTwo : end) {
          final var arr = new ArrayList<>(listOne);
          arr.addAll(listTwo);
          Collections.sort(arr);
          result.add(arr);
        }
      }
    }

    return new ArrayList<>(result);
  }
}
