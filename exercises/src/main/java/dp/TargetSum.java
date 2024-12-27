package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TargetSum {
  public int findTargetSumWays(int[] nums, int target) {
    final var result = new LinkedList<Map<Integer, Integer>>();
    final var positive = new int[nums.length];
    final var negative = new int[nums.length];

    for (int i = 0; i < nums.length; i++) {
      positive[i] = nums[i];
      negative[i] = nums[i] * - 1;
    }

    final var firstMap = new HashMap<Integer, Integer>();
    firstMap.put(positive[0], firstMap.getOrDefault(positive[0], 0) + 1);
    firstMap.put(negative[0], firstMap.getOrDefault(negative[0], 0) + 1);

    result.add(firstMap);



    for (int i = 1; i < nums.length; i++) {
      final var map =  new HashMap<Integer, Integer>();
      final var prevMap = result.get(i - 1);

      for (final var entry : prevMap.entrySet()) {
        final var positiveNext = entry.getKey() + positive[i];
        final var negativeNext = entry.getKey() + negative[i];

        map.put(positiveNext, entry.getValue() + map.getOrDefault(positiveNext, 0));
        map.put(negativeNext, entry.getValue() + map.getOrDefault(negativeNext, 0));
      }


      result.add(map);
    }


    return result.get(nums.length - 1).getOrDefault(target, 0);
  }
}
