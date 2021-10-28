package exercises.array.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Sum3ToTarget {
  public List<List<Integer>> threeSum(int[] nums) {
    Arrays.sort(nums);
    final var set = new HashSet<List<Integer>>();

    var start = 0;
    var end = nums.length - 1;

    while (start < end) {
      final var startValue = nums[start];
      final var endValue = nums[end];
      for (int i = start + 1; i < end; i++) {
        final var other = nums[i];

        if (startValue + endValue + other == 0) set.add(List.of(startValue, other, endValue));
      }
    }

    return new ArrayList<>(set);
  }
}
