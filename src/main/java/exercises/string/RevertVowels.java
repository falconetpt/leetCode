package exercises.string;

import java.util.LinkedList;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RevertVowels {
  public String reverseVowels(final String s) {
    final var set = Set.of(
      'a',
      'A',
      'e',
      'E',
      'i',
      'I',
      'o',
      'O',
      'u',
      'U'
    );

    final var vowels = IntStream.range(0, s.length())
      .mapToObj(s::charAt)
      .filter(set::contains)
      .collect(Collectors.toCollection(LinkedList::new));

    final var result = new StringBuilder();

    for (final var c : s.toCharArray()) {
      if (set.contains(c)) {
        result.append(vowels.pollLast());
      } else {
        result.append(c);
      }
    }

    return result.toString();
  }
}
