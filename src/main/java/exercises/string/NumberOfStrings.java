package exercises.string;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public class NumberOfStrings {
  public int numberOfSubstrings(final String s) {
    final int[] array = new int[3];

    for (int i = 0; i < s.length(); i++) {
      array[s.charAt(i) - 'a'] += 1;
    }

    final var aCount = array[0];
    final var bCount = array[1];
    final var cCount = array[2];

    return numberOfSubstrings(s, 0, s.length() - 1, aCount, bCount, cCount, new HashSet<>());
  }

  private int numberOfSubstrings(final String s,
                                 final int start,
                                 final int end,
                                 final int aCount,
                                 final int bCount,
                                 final int cCount,
                                 final Set<String> seen) {
    if (Stream.of(aCount, bCount, cCount).anyMatch(x -> x == 0)
      || seen.contains(start + "_" + end)) {
      return 0;
    } else {
      final var nextChar = s.charAt(start);
      final var prevChar = s.charAt(end);
      seen.add(start + "_" + end);

      return 1
        + numberOfSubstrings(s, start + 1, end, aCount - (nextChar == 'a' ? 1 : 0), bCount - (nextChar == 'b' ? 1 : 0), cCount - (nextChar == 'c' ? 1 : 0), seen)
        + numberOfSubstrings(s, start, end - 1, aCount - (prevChar == 'a' ? 1 : 0), bCount - (prevChar == 'b' ? 1 : 0), cCount - (prevChar == 'c' ? 1 : 0), seen);

    }
  }
}
