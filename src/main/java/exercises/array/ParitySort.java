package exercises.array;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ParitySort {
  public int[] sortArrayByParityII(final int[] nums) {
    final var numsMap = Arrays.stream(nums)
      .boxed()
      .collect(Collectors.groupingBy(i -> i % 2));

    for (int i = 0; i < nums.length; i++) {
      nums[i] = numsMap.get(i % 2)
        .remove(0);
    }

    return nums;
  }
}
