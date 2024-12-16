package dp;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class ExtraStudents {
  public double maxAverageRatio(int[][] classes, int extraStudents) {
    final var priorityQueue = new PriorityQueue<int[]>(
        Comparator.comparing(a -> - (((double) a[0] + 1.0) / (a[1] + 1.0) - (double) a[0] / a[1]))
    );
    priorityQueue.addAll(Arrays.asList(classes));

    for (int i = 0; i < extraStudents; i++) {
      final var next = priorityQueue.poll();
      next[0]++;
      next[1]++;
      priorityQueue.add(next);
    }



    return priorityQueue.stream()
        .mapToDouble(e -> (double) e[0] / e[1])
        .average()
        .orElse(0);
  }
}
