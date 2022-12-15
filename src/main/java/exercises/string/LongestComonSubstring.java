package exercises.string;

public class LongestComonSubstring {
  public int longestCommonSubsequence(final String text1,
                                      final String text2) {
    final var base = text1.length() > text2.length()
      ? text2
      : text1;
    final var pivot = base.equals(text1)
      ? text2
      : text1;

    var start = 0;
    var result = 0;

    while (start < base.length() && result < pivot.length()) {


    }

    return result;
  }
}
