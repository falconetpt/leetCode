package dp;

import java.util.HashMap;

public class SameStringThrice {
  public int maximumLength(String s) {
    final var frequencyMap = new HashMap<String, Integer>();

    for (int i = 0; i < s.length(); i++) {
      final var stringBuilder = new StringBuilder();

      for (int j = i; j < s.length(); j++) {
        if (stringBuilder.length() == 0 || s.charAt(j - 1) == s.charAt(j)) {
          stringBuilder.append(s.charAt(j));
          frequencyMap.put(stringBuilder.toString(), frequencyMap.getOrDefault(stringBuilder.toString(), 0) + 1);
        } else {
          break;
        }
      }
    }

    var ans = -1;

    for (final var entryMap : frequencyMap.entrySet()) {
      if (entryMap.getValue() > 2) ans = Math.max(ans, entryMap.getKey().length());
    }

    return ans;
  }
}
