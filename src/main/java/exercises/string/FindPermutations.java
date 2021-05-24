package exercises.string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FindPermutations {
  public List<String> findAndReplacePattern(final String[] words,
                                            final String pattern) {
    final var charPattern = pattern.toCharArray();

    return Arrays.stream(words)
      .filter( w -> isSamePathern(w.toCharArray(), charPattern) )
      .collect( Collectors.toList());
  }

  private boolean isSamePathern(final char[] array, final char[] patthern) {
    if (array.length != patthern.length) {
      return false;
    } else {
      final var seen = new HashMap<Character, Character>(  );
      final var set = new HashSet<Character>(  );
      final var result = new StringBuilder(  );

      for (var i = 0; i < array.length; i++) {
        seen.putIfAbsent( patthern[i], array[i] );
        set.add( array[i] );

        if (!seen.get( patthern[i] ).equals( array[i] )) return false;

        result.append( seen.get( patthern[i] ) );
      }

      return set.size() == seen.size();
    }
  }

}
