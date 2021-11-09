package exercises.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FindNumOfValidWords {
  public List<Integer> findNumOfValidWords(final String[] words,
                                           final String[] puzzles) {
    final var wordSet = Arrays.stream(words)
      .map(x -> Map.entry(x.charAt(0), toSet(x)))
      .collect(Collectors.toList());
    final var result = new ArrayList<Integer>();

    for (int i = 0; i < puzzles.length; i++) {
      final var puzzleWord = puzzles[i];
      final var puzzle = toSet(puzzleWord);
      var count = 0;

      for (final var word : wordSet) {
        if (word.getKey() == puzzleWord.charAt(0)) {
          final var allMatch = puzzle
            .containsAll(word.getValue());

          if (allMatch) count++;
        }

      }

      result.add(count);
    }

    return result;
  }

  private Set<Character> toSet(final String s) {
    return IntStream.range(0, s.length())
      .mapToObj(s::charAt)
      .collect(Collectors.toSet());
  }
}
