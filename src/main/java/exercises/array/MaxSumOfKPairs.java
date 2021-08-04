package exercises.array;

import java.util.HashMap;

public class MaxSumOfKPairs {
  public int maxOperations(final int[] nums, final int k) {
    final var seenNumbers = new HashMap<Integer, Integer>();
    var count = 0;

    for (int i = 0; i < nums.length; i++) {
      final var element = nums[i];
      final var numberToLookFor = k - element;

      if (seenNumbers.getOrDefault(numberToLookFor, 0) > 0) {
        count++;
        seenNumbers.put(numberToLookFor, seenNumbers.get(numberToLookFor) - 1);
      } else {
        seenNumbers.putIfAbsent(element, 0);
        seenNumbers.put(element, seenNumbers.get(element) + 1);
      }
    }

    return count;
  }
}
