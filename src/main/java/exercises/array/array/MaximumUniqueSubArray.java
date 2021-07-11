package exercises.array.array;

import java.util.LinkedHashSet;
import java.util.LinkedList;

public class MaximumUniqueSubArray {
  public int maximumUniqueSubarray(int[] nums) {
    final var set = new LinkedHashSet<Integer>();
    final var list = new LinkedList<Integer>();
    var max = 0;


    for (final var i : nums) {
      if (set.contains(i)) {
        max = Math.max(max, set.stream().reduce(0, Integer::sum));

        while (list.peekFirst() != i) {
          set.remove(list.pollFirst());
        }

        list.add(list.pollFirst());
      } else {
        set.add(i);
        list.add(i);
      }
    }

    return Math.max(max, set.stream().reduce(0, Integer::sum));
  }
}
