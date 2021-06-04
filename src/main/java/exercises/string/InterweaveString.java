package exercises.string;

public class InterweaveString {
  public boolean isInterleave(final String s1, final String s2, final String s3) {
    final var strConcat = (s1 + s2);
    if (strConcat.length() == s3.length()) {
      return isInterleave(s1, 0, s2, 0, s3, 0);
    } else {
      return false;
    }
  }

  private boolean isInterleave(final String s1,
                               final int s1Index,
                               final String s2,
                               final int s2Index,
                               final String s3,
                               final int s3Index) {
    if (s1Index >= s1.length()
        && s2Index >= s2.length()
        && s3Index >= s3.length()) {
      return true;
    } else {
      final var s3Char = s3.charAt(s3Index);
      final var s1Char = s1Index >= s1.length() ? ' '  : s1.charAt(s1Index);
      final var s2Char = s2Index >= s2.length() ? ' '  : s2.charAt(s2Index);

      return s1Char == s3Char
        && isInterleave(s1, s1Index + 1, s2, s2Index, s3, s3Index + 1)
        || s2Char == s3Char
        && isInterleave(s1, s1Index, s2, s2Index + 1, s3, s3Index + 1);
    }
  }
}
