package exercises.array;

import java.util.Arrays;

public class LonguestCommonSubsequence {
  public int longestCommonSubsequence(final String text1, final String text2) {
    final var result = new int[text1.length() + 1][text2.length() + 1];

    for (int i = 1; i < result.length; i++) {
      for (int j = 1; j < result[i].length; j++) {
        final var text1Char = text1.charAt(i - 1);
        final var text2Char = text2.charAt(j - 1);
        final var newValue = text1Char == text2Char
          ? 1 + result[i-1][j-1]
          : result[i-1][j];

        result[i][j] = Math.max(newValue, result[i][j - 1]);
      }
    }

    return result[text1.length()][text2.length()];
  }
}
