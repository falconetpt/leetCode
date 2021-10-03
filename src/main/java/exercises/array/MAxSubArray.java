package exercises.array;

public class MAxSubArray {
  public int maxSubArray(final int[] nums) {
    var max = Integer.MIN_VALUE;
    var current = 0;
    var positive = false;


    for (int i = 0; i < nums.length; i++) {
      final var element = nums[i];
      if (element > 0) positive = true;
      current += element;
      max = Math.max(current, max);

      if (current < 0) current = 0;
    }

    return positive
      ? Math.max(max, current)
      : max;
  }
}
