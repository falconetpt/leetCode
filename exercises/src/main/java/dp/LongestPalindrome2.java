package dp;

public class LongestPalindrome2 {
  public String longestPalindrome(String s) {
    var result = "";

    for (int i = 0; i < s.length(); i++) {
      final var localExpansionOdd = expandAroundTheCenter(s, i, i);
      final var localExpansionEven = expandAroundTheCenter(s, i, i + 1);

      final var localMax = localExpansionEven.length() > localExpansionOdd.length()
          ? localExpansionEven
          : localExpansionOdd;

      if (localMax.length() > result.length()) result = localMax;
    }


    return result;
  }

  public String expandAroundTheCenter(final String s, int start, int end) {
    while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
      start--;
      end++;
    }

    return s.substring(start + 1, end);
  }
}
