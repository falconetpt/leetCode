package dp;

public class FindMin {
  public int findMin(int[] nums) {
    return findMin(nums, 0, nums.length - 1);
  }

  private int findMin(int[] nums, int start, int end) {
    if (start == end) return nums[start];
    if (start + 1 == end) return Math.min(nums[start], nums[start + 1]);


    final var startValue = nums[start];
    final var endValue = nums[end];
    final var midValue = nums[(start + end) / 2];

    if (startValue > endValue) {
      return midValue > endValue
          ? findMin(nums, (start + end) / 2, end)
          : findMin(nums, start + 1, (start + end) / 2);
    } else {
      return startValue;
    }
  }
}
