package u.exercises;

import java.util.HashMap;

public class TwoSumEasy {
  public int[] twoSum(int[] nums, int target) {
    final var seen = new HashMap<Integer, Integer>();

    for (int i = 0; i < nums.length; i++) {
      final var element = nums[i];
      final var targetDiff = target - nums[i];

      if (seen.containsKey(targetDiff)) return new int[] {seen.get(targetDiff), i};
      seen.put(element, i);
    }

    return new int[0];
  }
}
