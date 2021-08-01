package exercises.array;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicateToArray {
  public boolean containsDuplicate(final int[] nums) {
    return containsDuplicate(nums, 0, new HashSet<>());
  }

  private boolean containsDuplicate(final int[] nums, final int i, final Set<Integer> integers) {
    if (i >= nums.length) {
      return false;
    } else {
      final var value = nums[i];

      if (integers.contains(value)) return true;

      integers.add(value);

      return containsDuplicate(nums, i + 1, integers);
    }
  }
}
