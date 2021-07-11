package exercises.array.array;

import java.util.Arrays;
import java.util.stream.Collectors;

public class MaximumLengthOfWords {
  public int maxProduct(final String[] words) {
    var max = 0;
    for (int i = 0; i < words.length; i++) {
      for (int j = 0; j < words.length; j++) {
        final var iWord = words[i];
        final var jWord = words[j];
        if (differentChars(iWord, jWord)) {
          max = Math.max(max, iWord.length() * jWord.length());
        }
      }
    }

    return max;
  }

  private boolean differentChars(final String a, final String b) {
    final var setA = Arrays.stream(a.split(""))
      .collect(Collectors.toSet());
    return Arrays.stream(b.split(""))
      .noneMatch(setA::contains);
  }
}
