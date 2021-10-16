package exercises.blind;

import java.util.HashMap;

public class TwoSum {
  public int[] twoSum(final int[] nums, final int target) {
    final var map = new HashMap<Integer, Integer>();

    for (int i = 0; i < nums.length; i++) {
      final var element = nums[i];
      final var difference = target - element;
      if (map.containsKey(difference)) return new int[] { map.get(difference), i };
      map.put(element, i);
    }

    return new int[] { -1, -1 };
  }
}
