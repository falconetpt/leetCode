package exercises;

import java.util.TreeMap;

public class LengthOfLIS {
  public int lengthOfLIS(int[] nums) {
    var max = 0;
    final var seenMap = new TreeMap<Integer, Integer>();

    for (int i = 0; i < nums.length; i++) {
      final var element = nums[i];
      final var entry = seenMap.headMap(element);

      if (entry.isEmpty()) {
        seenMap.put(element, 1);
      } else {
        final var highEntry = entry.entrySet()
          .stream()
          .sorted((a, b) -> -a.getValue().compareTo(b.getValue()))
          .findFirst()
          .orElseThrow();

        seenMap.put(element, highEntry.getValue() + 1);
        max = Math.max(max, highEntry.getValue() + 1);
      }
    }
    return max;
  }
}
