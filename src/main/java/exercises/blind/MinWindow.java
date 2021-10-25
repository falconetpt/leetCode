package exercises.blind;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MinWindow {
  public String minWindow(final String s, final String t) {
    if (t.length() > s.length()) return "";
    final var tSorted = Arrays.stream(t.split(""))
      .sorted()
      .reduce("", String::concat);
    final var sSorted = Arrays.stream(s.split(""))
      .sorted()
      .reduce("", String::concat);

    System.out.println("sSorted = " + sSorted);
    System.out.println("tSorted = " + tSorted);

    if (!sSorted.contains(tSorted)) return "";
    var result = s;

    for (int i = 0; i < s.length(); i++) {
      for (int j = s.length(); j > i; j--) {
        final var substr = s.substring(i, j);
        final var str = Arrays.stream(substr.split(""))
          .sorted()
          .reduce("", String::concat);
        if (str.contains(tSorted)) {
          result = substr.length() < result.length()
            ? substr
            : result;
        }
      }
    }

    return result;
  }
}
