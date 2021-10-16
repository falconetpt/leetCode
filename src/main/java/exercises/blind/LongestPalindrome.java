package exercises.blind;

public class LongestPalindrome {
  public String longestPalindrome(final String s) {
    var result = "";

    for (int i = 0; i < s.length(); i++) {
      for (int j = i ; j < s.length(); j++) {
        if (j - i + 1 > result.length() && isPalindrome(s, i, j)) {
          result = s.substring(i, j + 1);
        }
      }
    }

    return result;
  }

  private boolean isPalindrome(final String s, final int start, final int end) {
    if (start >= end) {
      return true;
    } else {
      final var startChar = s.charAt(start);
      final var endChar = s.charAt(end);

      return startChar == endChar
        && isPalindrome(s, start + 1, end - 1);
    }
  }
}
