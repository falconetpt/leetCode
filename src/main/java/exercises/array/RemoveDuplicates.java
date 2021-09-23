package exercises.array;

import java.util.LinkedHashMap;

public class RemoveDuplicates {
  public int removeDuplicates(final int[] nums) {
    final var result = new LinkedHashMap<Integer, Integer>();

    for (int i = 0; i < nums.length; i++) {
      final var element = nums[i];
      result.putIfAbsent(element, 0);
      result.put(element, Math.min(result.get(element) + 1, 2));
    }

    var index = 0;

    for (final var key : result.entrySet()) {
      for (int i = 0; i < key.getValue(); i++) {
        nums[index++] = key.getKey();
      }
    }

    return index;
  }
}
