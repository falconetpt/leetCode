package dp;

public class LongestSubStringPalindrome {
  public String longestPalindrome(String s) {
    var result = "";


    for (int i = 0; i < s.length(); i++) {
      final var center = expand(s, i, i);
      final var centerExpanded = expand(s, i, i + 1);
      final var max = center.length() > centerExpanded.length()
          ? center
          : centerExpanded;

      if (max.length() > result.length()) result = max;
    }

    return result;
  }

  private String expand(String s, int left, int right) {
    while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
      right++;
      left--;
    }

    return s.substring(left + 1, right);
  }
}
