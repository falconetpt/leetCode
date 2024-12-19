package dp;

import java.util.Arrays;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MaxChunks {
  public int maxChunksToSorted(int[] arr) {
    var count = 0;
    final var seen = IntStream.rangeClosed(0, arr.length)
        .boxed()
        .collect(Collectors.toCollection(TreeSet::new));

    for (int i = 0; i < arr.length; i++) {
      final var element = arr[i];
      seen.remove(element);

      if (i + 1 == seen.first()) {
        count++;
      }

    }

    return count;
  }
}
