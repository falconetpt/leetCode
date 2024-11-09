package u.exercises;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class WordBreak {
  public boolean wordBreak(String s, List<String> wordDict) {
    final var words = wordDict.stream().collect(Collectors.toSet());
    return containsWord(s, 0, words);
  }

  private boolean containsWord(final String s, int start, Set<String> words) {
    if (start >= s.length()) return true;

    final var sb = new StringBuilder();
    for (int i = start; i < s.length(); i++) {
      sb.append(s.charAt(i));

      if (words.contains(sb.toString())) {
        final var result = containsWord(s, i + 1, words);
        if (result) return true;
      }
    }

    return false;
  }
}
