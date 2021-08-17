package exercises.string;

public class StrStr {
  public int strStr(final String haystack, final String needle) {
    final var hayStackLength = haystack.length();
    final var needleLength = needle.length();

    for (int i = 0; i < hayStackLength - needleLength + 1; i++) {
      if (haystack.substring(i, i + needleLength).equals(needle)) return i;
    }

    return -1;
  }
}
