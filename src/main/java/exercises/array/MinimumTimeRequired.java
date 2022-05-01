package exercises.array;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MinimumTimeRequired {
  public int minimumTimeRequired(final int[] jobs, final int k) {
    final var prio = new PriorityQueue<>(Integer::compareTo);
    Arrays.stream(jobs, 0, k)
      .forEach(prio::add);

    var time = 0;
    var index = k;

    while (!prio.isEmpty()) {
      time++;
      final var value = prio.peek();

      if (time >= value) {
        time--;
        prio.poll();
        if (index < jobs.length) {
          prio.add(value + jobs[index++]);
        }
      }
    }

    return time;
  }
}
