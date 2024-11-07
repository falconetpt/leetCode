package u.exercises;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.IntStream;

public class TwoSum {
  public int[] twoSum(int[] nums, int target) {
    final var set = new HashMap<Integer, Integer>();

    for (int i = 0; i < nums.length; i++) {
      final var lookUp = target - nums[i];

      if (set.containsKey(lookUp)) {
        return new int[] {set.get(lookUp), i};
      }

      set.put(nums[i], i);
    }

    return new int[]{};
  }
}