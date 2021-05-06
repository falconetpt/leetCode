package exercises.string;

import java.util.Collections;
import java.util.Comparator;
import java.util.stream.IntStream;

public class WordFilter {
  private final String[] words;

  public WordFilter(final String[] words) {
    this.words = words;
  }

  public int f(String prefix, String suffix) {
    return IntStream.range(0, words.length)
      .boxed()
      .sorted(Collections.reverseOrder())
      .filter(x -> validPrefixSufix(prefix, suffix, words[x]))
      .findFirst()
      .orElse(-1);

  }

  private boolean validPrefixSufix(final String prefix,
                                   final String suffix,
                                   final String word) {
    return word.startsWith(prefix)
      && word.endsWith(suffix);
  }
}
