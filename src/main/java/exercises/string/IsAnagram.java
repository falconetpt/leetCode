package exercises.string;

import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class IsAnagram {
  public boolean isAnagram(final String s, final String t) {
    if (s.length() == t.length()) {
      final var sMap = IntStream.range(0, s.length())
        .mapToObj(s::charAt)
        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
      final var tMap = IntStream.range(0, t.length())
        .mapToObj(t::charAt)
        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

      return sMap.keySet()
        .stream()
        .allMatch(k -> sMap.getOrDefault(k, 0L).equals(tMap.getOrDefault(k, 0L)));

    } else {
      return false;
    }
  }
}
