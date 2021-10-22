package exercises.blind;

import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FrequencySort {
  public String frequencySort(final String s) {
    final var map = IntStream.range(0, s.length())
      .boxed()
      .map(s::charAt)
      .map(String::valueOf)
      .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

    return map.entrySet()
      .stream()
      .sorted((a, b) -> -a.getValue().compareTo(b.getValue()))
      .map(a -> IntStream.range(0, a.getValue().intValue()).mapToObj(i -> a.getKey()).collect(Collectors.joining()))
      .collect(Collectors.joining());
  }
}
