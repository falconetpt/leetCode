package exercises.array;

public class FindMinimum {
  public int findMin(int[] nums) {
    return findMin(nums, 0, nums.length - 1);
  }

  private int findMin(final int[] nums, final int start, final int end) {
    if (Math.abs(start - end) <= 1) {
      return Math.min(nums[start], nums[end]);
    } else {
      final var middle = (start + end) / 2;
      System.out.println(nums[middle]);

      if(nums[start] < nums[end]) {
        return nums[start];
      }

      if (nums[middle] < nums[start]) {
        return findMin(nums, start, middle);

      } else {
        return findMin(nums, middle, end);
      }
    }
  }
}
