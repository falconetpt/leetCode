package dp;

public class LoguestPalindromincSubstrings {
  public String longestPalindrome(String s) {
    return longestPalindrome(s, 0, s.length());
  }

  private String longestPalindrome(String s, int start, int end) {
    if (end - start == 1) return s.substring(start, start + 1);

    final var str = new StringBuilder(s.substring(start, end));
    final var direct = str.toString();

    // System.out.println(direct);

    if (direct.equals(str.reverse().toString())) return direct;

    final var left = longestPalindrome(direct, 1, direct.length());
    final var right = longestPalindrome(direct, 0, direct.length() -1);

    return left.length() > right.length()
        ? left
        : right;
  }
}
