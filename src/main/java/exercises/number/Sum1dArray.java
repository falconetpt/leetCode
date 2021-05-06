package exercises.number;

import java.util.Arrays;
import java.util.stream.Stream;

public class Sum1dArray {
  public int[] runningSum(int[] nums) {
    final int[] result = new int[nums.length];
    int runningSum = 0;

    for (int i = 0, size = nums.length; i < size; i++) {
      runningSum += nums[i];
      result[i] = runningSum;
    }

    return result;
  }
}
