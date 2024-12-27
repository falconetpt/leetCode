package dp;

import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RansomNote {
  public boolean canConstruct(String ransomNote, String magazine) {
    final var magazineFrequency = IntStream.range(0, magazine.length())
        .boxed()
        .map(magazine::charAt)
        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));


    for (final var nextChar : ransomNote.toCharArray()) {
      if (magazineFrequency.getOrDefault(nextChar, 0L) > 0L) {
        return false;
      } else {
        magazineFrequency.put(nextChar, magazineFrequency.getOrDefault(nextChar, 0L) - 1);
      }
    }

    return true;
  }
}
