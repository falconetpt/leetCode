package exercises.array;

import java.util.HashSet;

public class DuplicateNumber {
  public int findDuplicate(final int[] nums) {
    final var set = new HashSet<Integer>();

    for (int i = 0; i < nums.length; i++) {
      final var element = nums[i];
      if (set.contains(element)) {
        return element;
      }
      set.add(element);
    }

    return -1;
  }
}
