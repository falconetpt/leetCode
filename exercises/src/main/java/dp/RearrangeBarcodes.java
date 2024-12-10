package dp;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class RearrangeBarcodes {
  public int[] rearrangeBarcodes(int[] barcodes) {
    final var queue = Arrays.stream(barcodes)
        .boxed()
        .sorted()
        .collect(Collectors.toCollection(LinkedList::new));
    final var result = new int[barcodes.length];
    int i = 0;

    while (queue.size() > 1) {
      result[i++] = queue.pollFirst();
      result[i++] = queue.pollLast();
    }

    if (!queue.isEmpty()) result[i] = queue.pollLast();

    return result;
  }
}
