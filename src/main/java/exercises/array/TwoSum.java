package exercises.array;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
  public int[] twoSum(final int[] nums, final int target) {
    return twoSum(nums, 0, target, new HashMap<>());
  }

  private int[] twoSum(final int[] nums,
                       final int i,
                       final int target,
                       final Map<Integer, Integer> integers) {
    if (i >= nums.length) {
      return new int[] {};
    } else {
      final var value = nums[i];
      final var difference = target - nums[i];

      if (integers.containsKey(difference)) return new int[] { integers.get(difference), i };

      integers.put(value, i);

      return twoSum(nums, i + 1, target, integers);
    }

  }
}
