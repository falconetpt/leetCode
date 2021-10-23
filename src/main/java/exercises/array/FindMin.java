package exercises.array;

import java.util.Arrays;

public class FindMin {
  public int findMin(final int[] nums) {
    return Arrays.stream(nums)
      .min()
      .orElse(-1);
  }

  public int findMin(final int[] nums, final int start, final int end) {
    final var startElement = nums[start];
    final var endElement = nums[end];

    if (startElement < endElement) {
      if (start == 0) return startElement;
      return findMin(nums, 0, start);
    } else if (end - start == 1) {
      return Math.min(startElement, endElement);
    } else {
      return findMin(nums, (start + end) / 2, end);
    }
  }

}
