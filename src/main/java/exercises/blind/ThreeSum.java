package exercises.blind;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class ThreeSum {
  public List<List<Integer>> threeSum(final int[] nums) {
    Arrays.sort(nums);
    final var result = new HashSet<List<Integer>>();

    for (int i = 0; i < nums.length; i++) {
      final var base = nums[i];
      var start = i + 1;
      var end = nums.length - 1;

      while (start < end) {
        final var startNum = nums[start];
        final var endNum = nums[end];
        final var sum = base + startNum + endNum;

        if (sum == 0) {
          result.add(List.of(base, startNum, endNum));
          start++;
        } else {
          if (sum > 0) {
            end--;
          } else {
            start++;
          }
        }
      }

    }

    return new ArrayList<>(result);
  }
}
