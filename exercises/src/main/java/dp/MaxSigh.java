package dp;

import java.util.Comparator;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.stream.IntStream;

public class MaxSigh {
  public int maxScoreSightseeingPair(int[] values) {
    final Comparator<Record> comparator = Comparator.comparing(a -> -(a.value - a.index));
    final var lastComp = comparator.thenComparing(a -> a.index)
        .thenComparing(a -> a.value);

    final var set = new TreeSet<>(lastComp);

    IntStream.range(0, values.length)
        .boxed()
        .map(i -> new Record(i, values[i]))
        .forEach(set::add);

    var max = 0;

    for(int i = 0; i < values.length - 1; i++) {
      final var element = new Record(i, values[i]);
      set.remove(element);
      final var next = set.first();

      max = Math.max(max, next.value + element.value + (element.index - next.index));
    }

    return max;
  }

  public record Record(int index, int value) {}
}
