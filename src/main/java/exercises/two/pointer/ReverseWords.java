package exercises.two.pointer;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ReverseWords {
  public String reverseWords(final String s) {
    final var result = new StringBuilder();
    final var strings = s.split(" ");

    return Arrays.stream(strings)
      .map(str -> new StringBuilder(str).reverse().toString())
      .collect(Collectors.joining(" "));
  }
}
