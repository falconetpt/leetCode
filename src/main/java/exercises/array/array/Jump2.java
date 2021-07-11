package exercises.array.array;

import java.util.Comparator;
import java.util.stream.IntStream;

public class Jump2 {
  public int jump(int[] nums) {
    if (nums.length <= 1) {
      return 0;
    }
    return jump(nums, 0, nums[0], 1);
  }

  private int jump(int[] nums, int startIndex, int hops, int result) {
    if (startIndex + hops >= nums.length - 1) {
      return result;
    } else {
      int nextIndex = IntStream.rangeClosed(startIndex, Math.min(startIndex + hops, nums.length - 1))
        .boxed()
        .filter(i -> nums[i] > 0)
        .max(Comparator.comparingInt(a -> nums[a] + a - startIndex))
        .orElse(startIndex);

      return jump(nums, nextIndex, nums[nextIndex], result + 1);
    }
  }
}
