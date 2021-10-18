package exercises.blind;

public class SearchRotatedArray {
  public int search(final int[] nums, final int target) {
    return search(nums, target, 0, nums.length * 2 -1);
  }

  private int search(final int[] nums, final int target,
                     final int start, final int end) {
    if (start > end) {
      return -1;
    } else {
      final var index = ((start + end) / 2) % nums.length;
      final var value = nums[index];

      if (value == target) return index;

      if (value > target) {
        return search(nums, target, index + 1, end);
      } else {
        return search(nums, target, start, index -1);
      }
    }
  }
}
