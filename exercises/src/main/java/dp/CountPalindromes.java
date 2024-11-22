package dp;

import java.util.ArrayList;
import java.util.HashSet;

public class CountPalindromes {
  public int countSubstrings(String s) {
    final var set = new ArrayList<String>();

    for (int i = 0; i < s.length(); i++) {
      expandAroundTheCenter(s, i, i, set);
      expandAroundTheCenter(s, i, i + 1, set);
    }
    return set.size();
  }

  private void expandAroundTheCenter(String s, int start, int end, ArrayList<String> set) {
    while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
      final var str = s.substring(start, end + 1);
      if (str.length() > 0) set.add(str);

      start--;
      end++;
    }
  }
}
