package exercises.blind;

import java.util.Arrays;
import java.util.stream.IntStream;

public class ValidAnagram {
  public boolean isAnagram(final String s, final String t) {
    final var counter = new int[26];
    IntStream.range(0, s.length())
      .map(i -> s.charAt(i) - 'a')
      .forEach(i -> counter[i]++);

    IntStream.range(0, t.length())
      .map(i -> t.charAt(i) - 'a')
      .forEach(i -> counter[i]--);

    return Arrays.stream(counter)
      .allMatch(i -> i == 0);
  }
}
