package dp;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

public class FindScore {
  public long findScore(int[] nums) {
    final Comparator<int[]> comparator = Comparator.comparing(a -> a[0]);
    final Comparator<int[]> comparatorIndex = comparator.thenComparing(a -> a[1]);

    final var priorityQueue = new PriorityQueue<>(comparatorIndex);

    IntStream.range(0, nums.length).forEach(i -> priorityQueue.add(new int[] {nums[i], i}));

    final var seen = new HashSet<Integer>();

    return findScore(nums, priorityQueue, seen);
  }

  private long findScore(int[] nums, PriorityQueue<int[]> priorityQueue, HashSet<Integer> seen) {
    if (priorityQueue.isEmpty()) return 0;

    final var next = priorityQueue.poll();
    if (seen.contains(next[1])) return findScore(nums, priorityQueue, seen);

    seen.add(next[1]);
    seen.add(next[1] - 1);
    seen.add(next[1] + 1);

    return next[0] + findScore(nums, priorityQueue, seen);
  }
}
