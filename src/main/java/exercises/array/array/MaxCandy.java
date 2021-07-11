package exercises.array.array;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class MaxCandy {
  public int maxIceCream(int[] costs, int coins) {
    final var sortedList = Arrays.stream(costs)
      .boxed()
      .sorted()
      .collect(Collectors.toCollection(LinkedList::new));

    return maxIceCream(sortedList, coins);
  }

  public int maxIceCream(final LinkedList<Integer> costs, int coins) {
    if (costs.isEmpty() || costs.peekFirst() > coins) {
      return 0;
    } else {
      final var value = costs.pollFirst();

      return 1 + maxIceCream(costs, coins - value);
    }
  }
}
