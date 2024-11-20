package dp;

import java.util.Comparator;
import java.util.HashMap;
import java.util.TreeMap;

public class IncreasingSubSequence {
  public int lengthOfLIS(int[] nums) {
    final var map = new TreeMap<Integer, Integer>();
    var max = 1;
    var count = 1;
    map.put(nums[nums.length - 1], 1);

    for (int i = nums.length - 2; i >= 0; i--) {
      final var current = nums[i];

      count += map.tailMap(current + 1).values().stream().max(Comparator.comparingInt(a -> a)).orElse(0);
      map.put(current, Math.max(map.getOrDefault(current, 1), count));
      max = Math.max(map.get(current), max);
      count = 1;


      //System.out.println("map = " + map);
    }

    return max;
  }
}
