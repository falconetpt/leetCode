package exercises.number;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MissingRolls {
  public int[] missingRolls(int[] rolls, int mean, int n) {
    final var elements = rolls.length + n;
    final var targetValue = mean * elements;
    final var rollSum = Arrays.stream(rolls)
      .sum();
    final var meanElement = (targetValue - rollSum) / n;
    return meanElement > 6
      ? new int[] {}
      : missingRolls((targetValue - rollSum), meanElement, n, new ArrayList<>());
  }

  private int[] missingRolls(final int target,
                             final int meanElement,
                             final int n,
                             final List<Integer> integers) {
    if (n == 1) {
      integers.add(target);
      return target > 0 && target < 7
        ? integers.stream().mapToInt(i -> i).toArray()
        : new int[] {};
    } else {
      integers.add(meanElement);
      return missingRolls(target - meanElement, meanElement, n - 1, integers);
    }
  }
}
