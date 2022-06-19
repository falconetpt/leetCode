package exercises.array.array;

import java.util.HashSet;
import java.util.LinkedList;

public class MaximumUniqueSubarraySum {
  public int maximumUniqueSubarray(final int[] nums) {
    final var set = new HashSet<Integer>();
    final var link = new LinkedList<Integer>();
    var local = 0;
    var max = Integer.MIN_VALUE;

    for (final var num : nums) {
      if (!link.isEmpty() && set.contains(num)) {
        while (!link.peekFirst().equals(num)) {
          final var element = link.pollFirst();
          set.remove(element);
          local -= element;
        }
        link.add(link.pollFirst());
      } else {
        link.add(num);
        set.add(num);
        local += num;
      }
      max = Math.max(local, max);
    }

    return max;
  }
}
