package exercises.string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NumSplits {
  public int numSplits(final String s) {
    final var rightSideFrequency = IntStream.range(0, s.length())
      .mapToObj(s::charAt)
      .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

    final var leftSideFrequency = new HashMap<Character, Long>();

    var result = 0;

    for (int i = 0; i < s.length(); i++) {
      final var letter = s.charAt(i);

      rightSideFrequency.put(letter, rightSideFrequency.get(letter) - 1);
      leftSideFrequency.put(letter, leftSideFrequency.getOrDefault(letter, 0L) + 1);

      if (rightSideFrequency.get(letter) == 0) {
        rightSideFrequency.remove(letter);
      }


      if (leftSideFrequency.size() > rightSideFrequency.size()) {
        return result;
      }

      if (leftSideFrequency.size() == rightSideFrequency.size()) {
        result++;
      }
    }

    return result;
  }
}
