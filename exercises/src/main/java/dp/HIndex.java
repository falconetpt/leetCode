package dp;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class HIndex {
  public int hIndex(int[] citations) {
    var count = 0;

    for (int i = citations.length; i >= 0; i--) {
      count++;
      final var value = citations[i];
      if (count >= value) return value;
    }

    return -1;
  }
}
