package exercises.string;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class FrequencySort {
  public String frequencySort(String s) {
    final var frequency = Arrays.stream(s.split(""))
      .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

    return frequency.entrySet()
      .stream()
      .sorted((a, b) -> b.getValue().compareTo(a.getValue()))
      .map(e -> LongStream.range(0,  e.getValue()).mapToObj(el -> e.getKey()).reduce("", String::concat))
      .reduce("", String::concat);
  }
}
