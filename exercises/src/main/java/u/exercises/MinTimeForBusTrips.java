package u.exercises;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MinTimeForBusTrips {
  public long minimumTime(int[] time, int totalTrips) {
    final var priorityQueue = new PriorityQueue<Data>(Comparator.comparing(d -> d.time));
    IntStream.range(0, time.length)
        .boxed()
        .map(i -> new Data(time[i], i))
        .forEach(priorityQueue::add);

    return minimumTime(time, totalTrips, priorityQueue);
  }

  private long minimumTime(int[] time, int totalTrips, PriorityQueue<Data> priorityQueue) {
    if (totalTrips <= 0) {
      return 0l;
    } else {
      final var newPriorityQueue = new PriorityQueue<Data>(Comparator.comparing(d -> d.time));
      var count = 0l;

      while (!priorityQueue.isEmpty()) {
        final var element = priorityQueue.poll();
        final var index = element.busIndex;
        if (element.time - 1 == 0) {
          newPriorityQueue.add(new Data(time[index], index));
          count++;
        } else {
          newPriorityQueue.add(new Data(element.time - 1, index));
        }
      }

      return 1 + minimumTime(time, totalTrips - (int) count, newPriorityQueue);
    }
  }

  private record Data(int time, int busIndex) {}
}
