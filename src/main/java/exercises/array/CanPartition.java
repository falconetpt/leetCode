package exercises.array;

import java.util.ArrayList;
import java.util.Arrays;

public class CanPartition {
  public boolean canPartition(final int[] nums) {
    final var sum = Arrays.stream(nums)
      .sum();

    if (sum % 2 != 0) return false;

    final var mid = sum / 2;

    final var cache = new ArrayList<Integer>();
    cache.add(0);

    for (final var num : nums) {
      final var localList = new ArrayList<Integer>();
      for (final var element : cache) {
        final var value = element + num;

        if (value == mid) return true;

        localList.add(value);
      }
      cache.addAll(localList);
    }

    return false;
  }
}
