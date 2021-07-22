package exercises.two.pointer;

import java.util.LinkedList;

public class SortArrayByParity {
  public int[] sortArrayByParity(final int[] nums) {
    final var result = new LinkedList<Integer>();

    for (int i = 0; i < nums.length; i++) {
      if (nums[i] % 2 == 0) {
        result.addFirst(nums[i]);
      } else {
        result.addLast(nums[i]);
      }
    }

    return result.stream()
      .mapToInt(i -> i)
      .toArray();
  }
}
