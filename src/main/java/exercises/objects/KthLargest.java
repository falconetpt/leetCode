package exercises.objects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class KthLargest {
  private final List<Integer> queue;
  private final int k;

  public KthLargest(int k, int[] nums) {
    this.k = k;
    queue = Arrays.stream(nums)
      .boxed()
      .sorted()
      .collect(Collectors.toCollection(ArrayList::new));
  }

  public int add(int val) {
    IntStream.range(0, queue.size() - 1)
      .filter(i -> val >= queue.get(i) && val <= queue.get(i + 1))
      .findFirst()
      .ifPresentOrElse(i -> queue.add(i, val), () -> queue.add(val));
    return queue.get(queue.size() - k + 1);
  }
}
