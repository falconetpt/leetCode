package exercises.array;

import java.util.HashSet;
import java.util.LinkedList;

public class SingleNumber {
  public int[] singleNumber(final int[] nums) {
    final var seen = new HashSet<Integer>();
    final var result = new HashSet<>();

    for(final var num : nums) {
      if (seen.contains(num)) {
        result.remove(num);
      } else {
        seen.add(num);
        result.add(num);
      }
    }


    return result.stream()
      .mapToInt(i -> (int) i)
      .toArray();
  }
}
