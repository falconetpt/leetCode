package dp;

public class LoguestPalindromincSubstrings {
  public String longestPalindrome(String s) {
    return longestPalindrome(s, 0, s.length());
  }

  private String longestPalindrome(String s, int start, int end) {
    if (end - start == 1) return s.substring(start, 1);

    final var str = new StringBuilder();
    str.substring(start, end);
    final var direct = str.toString();

    if (direct.equals(str.reverse().toString())) return direct;

    final var left = longestPalindrome(s, start + 1, end);
    final var right = longestPalindrome(s, start, end -1);

    return left.length() > right.length()
        ? left
        : right;
  }
}
