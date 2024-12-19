package dp;

import java.util.Arrays;
import java.util.stream.Collectors;

public class TwoEqualStrings {
  public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
    final var word1Str = Arrays.stream(word1).collect(Collectors.joining()); // O(n) space/time
    final var word2Str = Arrays.stream(word2).collect(Collectors.joining()); // O(n) space/time

    return word1Str.equals(word2Str);
  }
}
