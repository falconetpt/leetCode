package exercises.number;

import java.util.Comparator;
import java.util.PriorityQueue;

public class BrokenCalc {
  public int brokenCalc(final int startValue,
                        final int target) {
    final var priorityQueue = new PriorityQueue<ValueMap>(Comparator.comparing(x -> x.count));
    priorityQueue.add(new ValueMap(startValue, 0));

    return brokenCalc(priorityQueue, target);
  }

  public int brokenCalc(final PriorityQueue<ValueMap> queue,
                        final int target) {
    final var element = queue.poll();

    if (element.value == target) {
      return element.count;
    } else {
      queue.add(new ValueMap(element.value - 1, element.count + 1));
      queue.add(new ValueMap(element.value * 2, element.count + 1));

      return brokenCalc(queue, target);
    }
  }

  class ValueMap {
    final int value;
    final int count;

    public ValueMap(final int value,
                    final int count) {
      this.value = value;
      this.count = count;
    }
  }
}
