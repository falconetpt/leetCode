package dp;

import java.util.HashMap;
import java.util.List;

public class WordBreakRound2 {
  public boolean wordBreak(String s, List<String> wordDict) {
    return wordBreak(s, wordDict, new HashMap<>());
  }

  public boolean wordBreak(String s, List<String> wordDict, HashMap<String, Boolean> cache) {
    if (s.length() == 0) return true;
    if (cache.containsKey(s)) return cache.get(s);

    final var match = wordDict
        .stream()
        .filter(s::startsWith)
        .anyMatch(w -> wordBreak(s.replaceFirst(w, ""), wordDict, cache));

    cache.put(s, match);

    return match;
  }
}
