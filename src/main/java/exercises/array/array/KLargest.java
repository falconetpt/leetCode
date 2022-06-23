package exercises.array.array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

public class KLargest {
  public int findKthLargest(int[] nums, int k) {
    final var prioQueue = new PriorityQueue<Integer>(Comparator.reverseOrder());

    Arrays.stream(nums).forEach(prioQueue::add);

    IntStream.range(0, k - 1).forEach(x -> prioQueue.poll());

    return prioQueue.poll();
  }
}
