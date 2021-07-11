package exercises.array.array;

public class LongestCommonSubSequence {
  public int lengthOfLIS(int[] nums) {
    return lengthOfLIS(nums, 0, 0,
      Integer.MAX_VALUE, Integer.MAX_VALUE);
  }

  private int lengthOfLIS(final int[] nums,
                          final int i,
                          final int maxSeq,
                          final int lastValue,
                          final int min) {
    if (i >= nums.length) {
      return maxSeq;
    } else {
      final var value = nums[i];

      if (value < min) {
        final var nextMin = lengthOfLIS(nums, i + 1,
          1, value, value
        );
        return Math.max(maxSeq, nextMin);
      } else {
        if (value > lastValue) {
          return lengthOfLIS(nums, i + 1, maxSeq + 1, value, min);
        } else {
          return lengthOfLIS(nums, i + 1, maxSeq, lastValue, min);
        }
      }
    }
  }
}
