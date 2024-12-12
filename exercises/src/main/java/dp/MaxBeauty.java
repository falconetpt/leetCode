package dp;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class MaxBeauty {
  public int maximumBeauty(int[] nums, int k) {
    final var frequencyMap = new HashMap<Integer, AtomicInteger>();
    var max = 0;

    for (final var num : nums) {
      for (int i = num - k; i <= num + k; i++) {
        frequencyMap.putIfAbsent(i, new AtomicInteger(0));
        final var newValue = frequencyMap.get(i).addAndGet(1);
        max = Math.max(max, newValue);
      }
    }

    return max;
  }
}
