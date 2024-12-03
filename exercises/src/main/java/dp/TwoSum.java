package dp;

import java.util.HashMap;

public class TwoSum {
  public int[] twoSum(int[] nums, int target) {
    final var seenMap = new HashMap<Integer, Integer>();

    for(int i = 0; i < nums.length; i++) {
      final var element = nums[i];
      final var elementToLookFor = target - element;

      if(seenMap.containsKey(elementToLookFor)) return new int[] { i, seenMap.get(elementToLookFor) };
      seenMap.put(element, i);
    }

    return new int[] {};
  }
}
