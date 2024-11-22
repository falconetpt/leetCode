package dp;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {
  public boolean wordBreak(String s, List<String> wordDict) {
    return wordBreak(s, wordDict, new HashMap<>());
  }

  public boolean wordBreak(String s, List<String> wordDict, HashMap<String, Boolean> seen) {
    if(s.length() == 0) return true;
    if (seen.containsKey(s)) return seen.get(s);

    final var result = wordDict.stream()
        .filter(s::startsWith)
        .map(w -> s.replaceFirst(w, ""))
        .anyMatch(newS -> wordBreak(newS, wordDict, seen));

    seen.put(s, result);

    return result;
  }

  public boolean wordBreak2(String s, List<String> wordDict) {
    boolean[] dp = new boolean[s.length() + 1];
    dp[0] = true;

    for (int i = 1; i <= s.length(); i++) {
      for (String w : wordDict) {
        int start = i - w.length();
        dp[i] = s.startsWith(w, start);
      }
    }
    return dp[s.length()];
  }
}
