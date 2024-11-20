package finalPrep;

import java.util.Arrays;
import java.util.HashMap;

public class SumOfK {
  public long maximumSubarraySum(int[] nums, int k) {
    final var accumulatedNum = createAccumulatedSum(nums, k);
    var max = (long) accumulatedNum[k -1];

    System.out.println(Arrays.toString(accumulatedNum));
    for (int i = k; i < accumulatedNum.length; i++) {
      System.out.println("---" + i + ": " + (accumulatedNum[i] - accumulatedNum[i-k]));
      max = Math.max(accumulatedNum[i] - accumulatedNum[i-k], max);
    }

    return max;
  }

  public int[] createAccumulatedSum(final int[] nums, final int k) {
    final var result = new int[nums.length];
    final var map = new HashMap<Integer, Integer>();
    var sum = 0;

    for(int i = 0; i < nums.length; i++) {
      map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
      if (i >= k) map.put(nums[i-k], map.getOrDefault(nums[i-k], 0) - 1);
      if (map.getOrDefault(nums[i], 0) == 1) {
        sum += nums[i];
        result[i] = sum;
      } else {
        result[i] = nums[i];
      }
    }

    return result;
  }
}
