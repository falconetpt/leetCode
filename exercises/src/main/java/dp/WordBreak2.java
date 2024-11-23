package dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WordBreak2 {
  public List<String> wordBreak(String s, List<String> wordDict) {

    final var result = wordBreak(s, wordDict, new HashMap<>(), new ArrayList<>(), "");

    return result;
  }

  public List<String> wordBreak(String s, List<String> wordDict, HashMap<String, List<String>> seen,
                                List<String> resultList, String finalS) {
    if(s.isEmpty()) {
      resultList.add(finalS.trim());
      return resultList;
    }

    wordDict.stream()
        .filter(s::startsWith)
        .forEach(w -> wordBreak(s.replaceFirst(w, ""), wordDict, seen, resultList, finalS + " " + w));

    seen.put(s, resultList);

    return resultList;
  }
}
