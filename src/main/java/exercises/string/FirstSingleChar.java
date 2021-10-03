package exercises.string;

import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FirstSingleChar {
  public int firstUniqChar(final String s) {
    final var map = IntStream.range(0, s.length())
      .mapToObj(s::charAt)
      .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

    for (int  i = 0; i < s.length(); i++) {
      final var c = s.charAt(i);
      if (map.get(c) == 1) return i;
    }

    return -1;
  }
}
