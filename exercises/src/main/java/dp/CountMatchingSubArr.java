package dp;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CountMatchingSubArr {
  public int countMatchingSubarrays(int[] nums, int[] pattern) {
    final var deltaArr = new int[nums.length - 1];
    final var sb = new StringBuilder();

    for (int i = 1; i < nums.length; i++) {
      var value = 0;
      if (nums[i] > nums[i - 1]) value = 1;
      if (nums[i] < nums[i - 1]) value = -1;
      sb.append(value).append(",");
    }

    final var arrStr = sb.toString();
    final var patthernStr = Arrays.stream(pattern).boxed().map(String::valueOf).collect(Collectors.joining(","));

    var count = 0;
    var index = 0;

    while (index != -1) {
      final var hasNext = arrStr.startsWith(patthernStr, index);
      if (hasNext) {
        index++;
        count++;
      } else {
        index = -1;
      }
    }

    return count;
  }
}
