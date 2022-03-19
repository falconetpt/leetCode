package exercises.string;

public class IsSubsequence {
  public boolean isSubsequence(final String s,
                               final String t) {
    return isSubsequence(s, t, 0, 0);

  }

  private boolean isSubsequence(final String s, final String t,
                                final int sIndex, final int tIndex) {
    if (sIndex >= s.length()) {
      return true;
    } else if (tIndex >= t.length()) {
      return false;
    } else {
      return s.charAt(sIndex) == t.charAt(tIndex)
        ? isSubsequence(s, t, sIndex + 1, tIndex + 1)
        : isSubsequence(s, t, sIndex, tIndex + 1);
    }
  }
}
