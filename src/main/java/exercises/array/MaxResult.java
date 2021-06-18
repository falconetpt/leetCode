package exercises.array;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class MaxResult {
  public int maxResult(int[] nums, int k) {
    final var cache = new HashMap<Integer, Integer>();
    return maxResult(nums, 0, k, cache);
  }

  private int maxResult(final int[] nums,
                        final int i,
                        final int k,
                        final Map<Integer, Integer> cache) {
    if (cache.containsKey(i)) {
      return cache.get(i);
    } else if (i == nums.length - 1) {
      cache.put(i, nums[i]);
      return cache.get(i);
    } else {
      final var maxNumber = IntStream.rangeClosed(i + 1, Math.min(nums.length - 1, i + k))
        .map(n -> nums[i] + maxResult(nums, n, k, cache))
        .max()
        .orElse(Integer.MIN_VALUE);
      cache.put(i, maxNumber);
      return maxNumber;
    }
  }
}
