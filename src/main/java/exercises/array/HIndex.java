package exercises.array;

import java.util.Arrays;

public class HIndex {
  public int hIndex(final int[] citations) {
    Arrays.sort(citations);

    for (int i = citations.length - 1; i >= 0 ; i++) {
      final var element = citations[i];

      if (element >= citations.length - element) return element;
    }

    return 0;
  }
}
