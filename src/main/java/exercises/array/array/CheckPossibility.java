package exercises.array.array;

import java.util.stream.IntStream;

public class CheckPossibility {
  public boolean checkPossibility(final int[] nums) {
    return IntStream
      .range(1, nums.length)
      .filter(i -> nums[i] < nums[i-1] )
      .count() > 1L;
  }
}
