package exercises.array;

import java.util.HashSet;
import java.util.Set;

public class SortArrayInPlace {
  public int removeDuplicates(int[] nums) {
    return removeDuplicates(nums, 0, new HashSet<>(), 0);
  }

  private int removeDuplicates(final int[] nums, final int i, final Set<Integer> seen, final int lastIndex) {
    if (i >= nums.length) {
      return seen.size();
    } else {
      final var value = nums[i];
      if (seen.contains(value)) {
        return removeDuplicates(nums, i + 1, seen, lastIndex);
      } else {
        seen.add(value);
        nums[lastIndex] = value;
        return removeDuplicates(nums, i + 1, seen, lastIndex + 1);
      }
    }
  }
}
