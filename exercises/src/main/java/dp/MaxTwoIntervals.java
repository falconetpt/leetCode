package dp;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class MaxTwoIntervals {
  public int maxTwoEvents(int[][] events) {
    final var result = Arrays.stream(events)
        .sorted(Comparator.comparingInt(a -> a[0]))
        .collect(Collectors.toCollection(LinkedList::new));

    return maxTwoEvents(result, new TreeMap<>(), 0);
  }

  private int maxTwoEvents(LinkedList<int[]> result, TreeMap<Integer, Integer> integerIntegerTreeMap, int max) {
    if (result.isEmpty()) return max;
    final var element = result.pollLast();
    final var weight = element[2];

    final var maxKey = integerIntegerTreeMap.ceilingEntry(element[1] + 1);
    final var maxValue = maxKey == null
        ? 0
        : maxKey.getValue();

    final var maxKey2 = integerIntegerTreeMap.ceilingEntry(element[0]);
    final var maxValue2 = maxKey2 == null
        ? 0
        : maxKey2.getValue();


    final var newMax = Math.max(
        Math.max(maxValue2, weight),
        integerIntegerTreeMap.getOrDefault(element[0], 0)
    );

    integerIntegerTreeMap.put(element[0], newMax);

    return maxTwoEvents(result, integerIntegerTreeMap, Math.max(maxValue + weight, max));
  }
}
