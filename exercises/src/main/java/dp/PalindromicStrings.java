package dp;

public class PalindromicStrings {
  public int countSubstrings(String s) {
    var count = 0;

    for (int i = 0; i < s.length(); i++) {
      count += expandAroundTheCenter(s, i, i);
      count += expandAroundTheCenter(s, i, i + 1);
    }

    return count;
  }

  private int expandAroundTheCenter(String s, int start, int end) {
    var result = 0;
    while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
      result++;
      start--;
      end++;
    }

    return result;
  }
}
