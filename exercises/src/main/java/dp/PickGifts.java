package dp;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class PickGifts {
  public long pickGifts(int[] gifts, int k) {
    final var priorityQueue = new PriorityQueue<Long>(Comparator.comparing(i -> -i));
    Arrays.stream(gifts).mapToLong(i -> i).forEach(priorityQueue::add);
    var sum = Arrays.stream(gifts).mapToLong(i -> i).sum();

    for (int i = 0; i < k; i++) {
      final var next = priorityQueue.poll();
      final var newValue = (long) Math.sqrt(next);
      sum -= next;
      sum += newValue;
      priorityQueue.add(newValue);
    }

    return sum;
  }
}
