package dp;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MaxSumFromRange {
  public int maxCount(int[] banned, int n, int maxSum) {
    final var bannedSet = Arrays.stream(banned)
        .boxed()
        .collect(Collectors.toSet());

    final var range = IntStream.rangeClosed(1, n)
        .boxed()
        .filter(i -> !bannedSet.contains(i))
        .collect(Collectors.toCollection(LinkedList::new));

    var sum = 0;
    var count = 0;

    while (sum <= maxSum && !range.isEmpty()) {
      final var nextElement = range.pollFirst();
      sum += nextElement;
      if (sum <= maxSum) count++;
    }

    return count;
  }
}
