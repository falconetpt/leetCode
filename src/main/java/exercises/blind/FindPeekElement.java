package exercises.blind;

import java.util.stream.IntStream;

public class FindPeekElement {
  public int findPeakElement(final int[] nums) {
    return IntStream.range(0, nums.length)
      .boxed()
      .reduce(0, (a, b) -> {
        if (nums[a] > nums[b]) return a;
        return b;
      });
  }
}
