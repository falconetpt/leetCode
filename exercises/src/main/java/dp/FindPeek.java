package dp;

public class FindPeek {
  public int findPeakElement(int[] nums) {
    if (nums.length == 1) return 0;

    return findPeakElement(nums, 0, nums.length);
  }

  private int findPeakElement(int[] nums, int start, int end) {
    if (start > end) return -1;

    final var mid = (start + end) / 2;

    if(mid -1 < 0 && nums[mid] > nums[mid + 1]) {
      return mid;
    } else if(mid + 1 >= nums.length && nums[mid] > nums[mid - 1]) {
      return mid;
    } else {
      if (nums[mid] > nums[mid + 1] && nums[mid] > nums[mid - 1]) return mid;
    }

    final var left = findPeakElement(nums, start, mid);
    if (left  == -1) return findPeakElement(nums, mid + 1, end);

    return left;
  }
}
