package exercises.array;

import java.util.stream.IntStream;

public class SearchRotatedArray {
  public int search(final int[] nums, final int target) {
    final var start = IntStream.range(1, nums.length)
      .filter(i -> nums[i] < nums[i -1])
      .findFirst()
      .orElse(0);

    return search(nums, start, start + nums.length - 1, target);
  }

  private int search(final int[] nums, final int start, final int end, final int target) {
    if (start > end) {
      return -1;
    } else {
      final var middle = (start + end) / 2;
      final var index = middle % nums.length;
      final var element = nums[index];

      if (element == target) {
        return index;
      }

      if (element > target) {
        return search(nums, start, middle - 1, target);
      } else {
        return search(nums, middle + 1, end, target);
      }
    }
  }
}
