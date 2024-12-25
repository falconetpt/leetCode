package dp;

import java.util.HashMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MinWindow {
  public String minWindow(String s, String t) {
    var min = Integer.MAX_VALUE;
    var result = "";
    final var frequencyT = IntStream.range(0, t.length())
        .boxed()
        .map(t::charAt)
        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

    final var frequencyS = new HashMap<Character, Long>();

    var left = 0;
    var right = 0;

    while (right < s.length()) {
      final var element = s.charAt(right);

      frequencyS.put(element, frequencyS.getOrDefault(element, 0L) + 1);
      final var isCheck = frequencyT.entrySet()
          .stream()
          .allMatch(e -> frequencyS.getOrDefault(e.getKey(), 0L) >= e.getValue());

      while (isCheck && frequencyT.containsKey(element)
          && frequencyS.getOrDefault(s.charAt(left), 1L) > frequencyT.getOrDefault(s.charAt(left), 0L)) {
        final var str = s.charAt(left++);
        frequencyS.put(str, frequencyS.getOrDefault(str, 1L) - 1);
      }

      if (isCheck && (right - left) < min) {
        min = right - left;
        result = s.substring(left, right + 1);

      }

      right++;

    }


    return result;
  }
}
