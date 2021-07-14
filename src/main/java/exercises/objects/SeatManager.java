package exercises.objects;

import java.util.PriorityQueue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SeatManager {
  private final PriorityQueue<Integer> queue;

  public SeatManager(int n) {
    queue = IntStream.rangeClosed(1, n)
      .boxed()
      .collect(Collectors.toCollection(PriorityQueue::new));
  }

  public int reserve() {
    return queue.poll();
  }

  public void unreserve(int seatNumber) {
    queue.add(seatNumber);
  }
}
