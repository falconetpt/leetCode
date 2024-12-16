package dp;

import java.util.HashMap;
import java.util.List;

public class WordBreak3 {
  public boolean wordBreak(String s, List<String> wordDict) {
    return wordDict(s, wordDict, new HashMap<String, Boolean>());
  }

  private boolean wordDict(String s, List<String> wordDict, HashMap<String, Boolean> stringBooleanHashMap) {
    if (s.isEmpty()) return true;
    if (stringBooleanHashMap.containsKey(s)) return stringBooleanHashMap.get(s);

    final var canReach = wordDict.stream()
        .filter(s::startsWith)
        .anyMatch(w -> wordDict(s.replaceFirst(w, ""), wordDict, stringBooleanHashMap));

    stringBooleanHashMap.put(s, canReach);

    return canReach;
  }
}
