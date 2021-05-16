package exercises.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PartitionLabels {
  public List<Integer> partitionLabels(final String s) {
    if (s == null || s.isEmpty()) return Collections.emptyList();
    final var frequency = Arrays.stream(s.split(""))
      .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

    final var queue = Arrays.stream(s.split(""))
      .collect(Collectors.toCollection(LinkedList::new));

    return partitionLabels(
      queue,
      frequency,
      0,
      new ArrayList<>(),
      new HashSet<>()
    );
  }

  private List<Integer> partitionLabels(final LinkedList<String> queue,
                                        final Map<String, Long> frequency,
                                        final int length,
                                        final List<Integer> integers,
                                        final Set<String> seen) {
    if (queue.isEmpty()) {
      return integers;
    } else {
      final var next = queue.pollFirst();
      frequency.put(next, frequency.get(next) - 1);

      if (frequency.get(next) == 0L) {
        seen.remove(next);
      } else {
        seen.add(next);
      }

      if (seen.isEmpty()) {
        integers.add(length + 1);
        return partitionLabels(queue, frequency, 0, integers, seen);
      } else {
        return partitionLabels(queue, frequency, length + 1, integers, seen);
      }
    }
  }
}
