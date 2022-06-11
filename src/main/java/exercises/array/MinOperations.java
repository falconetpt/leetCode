package exercises.array;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MinOperations {
  public int minOperations(final int[] nums, final int x) {
    var result = Integer.MAX_VALUE;

    for (int i = 0; i < nums.length; i++) {
      var sum = 0;
      var beginning = false;
      var end = false;
      for (int j = i; j < nums.length + i; j++) {
        final var index = j % nums.length;
        sum += nums[index];
        if (index == 0) beginning = true;
        if (index == nums.length - 1) end = true;
        if (sum == x && (beginning || end)) result = Math.min(result, j - i + 1);
      }
    }

    return result == Integer.MAX_VALUE
      ? -1
      : result;
  }
}
