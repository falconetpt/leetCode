package exercises.array;

public class MaxAlternatingSubsequence {
  public long maxAlternatingSum(final int[] nums) {
    var max = 0;
    var multiplier = 1;
    var sum = 0;

    for (final var num : nums) {
      sum = Math.max(sum + num * multiplier, 0);
      max = Math.max(max, sum);
      multiplier *= -1;
    }

    return max;
  }
}
