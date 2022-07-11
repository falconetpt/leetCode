package exercises.string;

public class StringInterweave {
  public boolean isInterleave(final String s1,
                              final String s2,
                              final String s3) {
    if (s1.length() + s2.length() == s3.length()) {
      return isInterleave(s1, s2, s3, 0, 0, 0, new int[26], new int[26], new int[26]);
    } else {
      return false;
    }
  }

  private boolean isInterleave(final String s1,
                               final String s2,
                               final String s3,
                               final int i1,
                               final int i2,
                               final int i3,
                               final int[] s1Seen,
                               final int[] s2Seen,
                               final int[] s3Seen) {
    if (i3 >= s3.length()) {
      return true;
    } else {
      final var s1Char = s1.length() >= i1 ? ' ' : s1.charAt(i1);
      final var s2Char = s2.length() >= i2 ? ' ' : s2.charAt(i2);
      final var s3Char = s3.charAt(i3);
      s3Seen[s3Char - 'a']++;

      if (s1Char == s3Char) {
        s1Seen[s1Char - 'a']++;
        if (isInterleave(s1, s2, s3, i1 + 1, i2, i3 + 1, s1Seen, s2Seen, s3Seen)) return true;
        s1Seen[s1Char - 'a']--;
      }

      if (s2Char == s3Char) {
        s2Seen[s2Char - 'a']++;
        if (isInterleave(s1, s2, s3, i1, i2 + 1, i3 + 1, s1Seen, s2Seen, s3Seen)) return true;
        s2Seen[s2Char - 'a']--;
      }

      return false;
    }
  }
}
