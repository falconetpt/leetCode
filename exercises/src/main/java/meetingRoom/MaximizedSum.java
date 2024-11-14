package meetingRoom;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MaximizedSum {
  public int minimizedMaximum(int n, int[] quantities) {
    final var priorityQueue = new PriorityQueue<int[]>(Comparator.comparing(a -> -a[0]/a[1]));
    Arrays.stream(quantities).forEach(i -> priorityQueue.add(new int[] {i, 1}));

    if (n == quantities.length) {
      final var max = Arrays.stream(quantities)
          .max()
          .orElse(-1);

      return max;
    }

    var newN = n;

    while (newN > 0) {
      final var next = priorityQueue.poll();
      priorityQueue.add(new int[] {next[0], next[0] + 1});
      newN--;
    }

    final var result = (double) priorityQueue.peek()[0] / priorityQueue.peek()[1] + 0.5;

    return (int) result;
  }
}
