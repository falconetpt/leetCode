package exercises.u.exercises;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CheckInclusion {
  public boolean checkInclusion(String s1, String s2) {
    final var occurences = IntStream.range(0, s1.length())
        .boxed()
        .map(s1::charAt)
        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

    for (int i = 0; i < s2.length(); i++) {
      final var currentElement = s2.charAt(i);

      if (occurences.containsKey(currentElement)) {
        final var newSubstring = s2.substring(i, Math.min(i + s1.length(), s2.length()));

        final var localOcurrences = IntStream.range(0, newSubstring.length())
            .boxed()
            .map(newSubstring::charAt)
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        if (localOcurrences.equals(occurences)) return true;
      }
    }

    return false;
  }
}
