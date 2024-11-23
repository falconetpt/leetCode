package dp;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

public class PartitionArray {
  public boolean canPartition(int[] nums) {
    final var sum = Arrays.stream(nums).sum();
    final var half = sum / 2;
    if (half * 2 != sum) return false;

    final var dp = new int[half + 1];
    Arrays.sort(nums); // O (n log n)

    Arrays.stream(nums).forEach(n -> dp[n]++);
    if (nums[nums.length - 1] > half) return false;

    for (int i = 1; i < dp.length; i++) {
      final var currentValue = i;
      for (final var num : nums) {
        final var previous = currentValue - num;
        if (previous >= 0 && dp[previous] > 0 && dp[num] > 0) {
          dp[previous]--;
          dp[num]--;
          dp[currentValue]++;
        } else {
          break;
        }
      }
    }

    System.out.println(Arrays.toString(dp));
    return dp[half] >= 2;
  }
}
