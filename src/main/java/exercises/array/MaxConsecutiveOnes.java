package exercises.array;

public class MaxConsecutiveOnes {

  public int findMaxConsecutiveOnes(final int[] nums) {
    return findMaxConsecutiveOnes(nums, 0, 0);
  }

  private int findMaxConsecutiveOnes(final int[] nums, final int i, final int result) {
    if (i >= nums.length) {
      return result;
    } else {
      final var element = nums[i];

      return element == 1
        ? findMaxConsecutiveOnes(nums, i + 1, result + 1)
        : Math.max(result, findMaxConsecutiveOnes(nums, i + 1, 0));
    }
  }
}
