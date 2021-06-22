package exercises.array;

import java.util.Arrays;

public class NumberOfSubstrings {
  public int numMatchingSubseq(String s, String[] words) {
    return (int) Arrays.stream(words)
      .map(String::toCharArray)
      .filter(chars -> isValidSubstring(chars, 0, 0, s))
      .count();
  }

  private boolean isValidSubstring(final char[] chars,
                                   final int iIndex,
                                   final int sindex,
                                   final String s) {
    if (iIndex >= chars.length) {
      return true;
    } else {
      final var nextChar = chars[iIndex];
      final var newSIndex = s.indexOf(nextChar, sindex);

      if (newSIndex == -1) {
        return false;
      } else {
        return isValidSubstring(chars, iIndex + 1, newSIndex + 1, s);
      }
    }
  }
}
