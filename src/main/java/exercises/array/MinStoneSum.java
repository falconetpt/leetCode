package exercises.array;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MinStoneSum {
  public int minStoneSum(int[] piles, int k) {
    final var sorted = new PriorityQueue<Integer>((a, b) -> -a.compareTo(b));
    Arrays.stream(piles)
      .forEach(sorted::add);

    for (int i = 0; i < k; i++) {
      final var number = sorted.poll();
      sorted.add((int) Math.floor(number / 2.0));
    }

    return sorted.stream()
      .reduce(0, Integer::sum);
  }
}
