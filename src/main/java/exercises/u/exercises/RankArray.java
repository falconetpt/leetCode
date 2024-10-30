package exercises.u.exercises;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

public class RankArray {
  public int[] arrayRankTransform(final int[] arr) {
    final var priorityQueue = new PriorityQueue<>(Integer::compareTo);
    final var result = new int[arr.length];
    final var seen = new HashSet<Integer>();
    final var ranking = new HashMap<Integer, Integer>();

    Arrays.stream(arr)
        .filter(e -> !seen.contains(e))
        .peek(seen::add)
        .forEach(priorityQueue::add);

    int rankingIndex = 1;
    while (!priorityQueue.isEmpty()) {
      ranking.put(priorityQueue.poll(), rankingIndex++);
    }


    IntStream.range(0, arr.length)
        .forEach(i -> result[i] = ranking.get(arr[i]));

    return result;
  }
}
