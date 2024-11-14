package meetingRoom;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

public class HireKCandidates {
  public long totalCost(int[] costs, int k, int candidates) {
    final Comparator<Data> compareValue = Comparator.comparing(d -> d.value);
    final var compareIndex = compareValue.thenComparing(d -> d.index);

    final var privateQueueHead = new PriorityQueue<>(compareIndex);
    var nextHead = candidates;
    final var privateQueueTail = new PriorityQueue<>(compareIndex);
    var nextTail = costs.length - candidates - 2;

    final var seenIndexes = new HashSet<Integer>();
    IntStream.range(0, candidates)
        .boxed()
        .filter(seenIndexes::add)
        .map(i -> new Data(costs[i], i))
        .forEach(privateQueueHead::add);

    IntStream.range(nextTail + 1, costs.length )
        .boxed()
        .filter(seenIndexes::add)
        .map(i -> new Data(costs[i], i))
        .forEach(privateQueueTail::add);

    var cost = 0l;
    var remaining = k;


    while (remaining > 0) {
      final var headValue = privateQueueHead.peek();
      final var tailValue = privateQueueTail.peek();

      if (headValue.value == tailValue.value) {
        if (headValue.index > tailValue.value) {
          privateQueueTail.poll();
        } else {
          privateQueueHead.poll();
        }
        cost += headValue.value;
      } else if (headValue.value > tailValue.value) {
        privateQueueTail.poll();
        cost += headValue.value;
      } else {
        privateQueueHead.poll();
        cost += headValue.value;
      }

      if (privateQueueHead.size() > privateQueueTail.size()) nextTail = calculateTail(nextTail, costs, privateQueueTail, seenIndexes);
      if (privateQueueHead.size() < privateQueueTail.size()) nextHead = calculateHead(nextHead, costs, privateQueueHead, seenIndexes);
    }



    return cost;
  }

  private int calculateHead(int nextHead, int[] costs, PriorityQueue<Data> privateQueueHead, HashSet<Integer> seenIndexes) {
    for (int i = nextHead; i < costs.length; i++) {
      if (!seenIndexes.contains(i)) {
        privateQueueHead.add(new Data(costs[i], i));
        seenIndexes.add(i);
        return i;
      }
    }

    return -1;
  }

  private int calculateTail(int nextTail, int[] costs, PriorityQueue<Data> privateQueueTail, HashSet<Integer> seenIndexes) {

    for (int i = nextTail; i >= 0; i--) {
      if (!seenIndexes.contains(i)) {
        privateQueueTail.add(new Data(costs[i], i));
        seenIndexes.add(i);
        return i;
      }
    }

    return -1;
  }

  public record Data(int value, int index) {}
}
