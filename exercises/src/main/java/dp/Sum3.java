package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Sum3 {
  public List<List<Integer>> threeSum(int[] nums) {
    final var result = new HashSet<List<Integer>>();


    Arrays.sort(nums);

    for (int i = 0; i < nums.length; i++) {
      final var start = nums[i];
      final var seen = new HashSet<Integer>();

      for (int j = i + 1; j < nums.length; j++) {
        final var current = nums[j];
        final var diffTarget = - start - current;

        if (seen.contains(diffTarget)) {
          result.add(List.of(start, diffTarget, current));
        }

        seen.add(current);
      }
    }


    return new ArrayList<>(result);
  }
}
