package exercises.string;

import java.util.List;

public class WrodBreak {
  public boolean wordBreak(final String s,
                           final List<String> wordDict) {
    if (s.isEmpty()) {
      return true;
    } else {
      for (final var word : wordDict) {

        if (s.indexOf(word) == 0 && wordBreak(s.replaceFirst(word, ""), wordDict)) return true;

      }

      return false;
    }
  }
}
