package exercises.array;

import java.util.ArrayList;
import java.util.stream.IntStream;

public class GasCost {
  public int canCompleteCircuit(final int[] gas, final int[] cost) {
    final var delta = new int[gas.length];
    final var elements = new ArrayList<Integer>();

    IntStream.range(0, delta.length)
      .peek(i -> delta[i] = gas[i] - cost[i])
      .filter(i -> delta[i] >= 0)
      .forEach(elements::add);

    for (final var element : elements) {
      if (canTravel(element, delta)) return element;
    }

    return -1;
  }

  private boolean canTravel(final int element, final int[] delta) {
    var sum = 0;

    for (int i = 0; i < delta.length; i++) {
      sum += delta[(i + element) % delta.length];
      if (sum < 0) return false;
    }

    return true;
  }
}
