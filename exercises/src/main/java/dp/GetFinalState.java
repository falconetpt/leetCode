package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

public class GetFinalState {
  public int[] getFinalState(int[] nums, int k, int multiplier) {
    final var result = new int[nums.length];
    final Comparator<int[]> comp = Comparator.comparing(a -> a[0]);
    final var finalComp = comp.thenComparing(a -> a[1]);
    final var pq = new PriorityQueue<int[]>(finalComp);

    IntStream.range(0, result.length).forEach(i -> {
      result[i] = nums[i];
      pq.add(new int[] {result[i], i});
    });


    for (int i = 0; i < k; i++) {
      final var next = pq.poll();
      result[next[1]] = next[0] * multiplier;
      pq.add(new int[] { result[next[1]], next[1] });
    }

    return result;
  }
}
