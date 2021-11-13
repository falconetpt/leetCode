package exercises.blind;

import java.util.HashSet;

public class ContainsDuplicate {
  public boolean containsDuplicate(int[] nums) {
    final var seen = new HashSet<Integer>();

    for (final var num : nums) {
      if (seen.contains(num)) return true;
      seen.add(num);
    }

    return false;
  }
}
