package exercises.number;

public class BinarySearch {
  public int search(final int[] nums,
                    final int target) {
    if (nums == null || nums.length == 0) {
      return -1;
    } else {
      return search(nums, 0, nums.length, target);
    }
  }

  private int search(final int[] nums,
                     final int start,
                     final int end,
                     int target) {
    if (start > end || start >= nums.length) {
      return -1;
    } else {
      final var mid = (start + end) / 2;
      final var value = nums[mid];

      if (value == target) return mid;

      if (value > target) {
        return search(nums, start, mid - 1, target);
      } else {
        return search(nums, mid + 1, end, target);
      }
    }
  }
}
