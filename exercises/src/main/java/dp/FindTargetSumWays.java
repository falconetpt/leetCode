package dp;

import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public class FindTargetSumWays {
  public int findTargetSumWays(int[] nums, int target) {
    final var cache = new HashMap<Integer, List<Integer>>();

    traverseOptions(nums, 0, target, cache);

    return (int) cache.get(0)
        .stream()
        .filter(i -> i == target)
        .count();
  }

  private List<Integer> traverseOptions(int[] nums, final int i, int target, HashMap<Integer, List<Integer>> cache) {
    if (i >= nums.length) return List.of(0);
    if (cache.containsKey(i)) return cache.get(i);

    final var value = nums[i];
    final var negative = -nums[i];

    final var next = traverseOptions(nums, i + 1, target, cache);
    final var toCache = next.stream().flatMap(num -> Stream.of(num + value, num + negative))
        .toList();

    cache.put(i, toCache);

    return toCache;
  }
}
