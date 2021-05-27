package exercises.array;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindLuckyNumber {
  public int findLucky(final int[] arr) {
    final var frequency = Arrays.stream(arr)
      .boxed()
      .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

    return frequency.keySet()
      .stream()
      .filter(k -> frequency.get(k).intValue() == k)
      .max(Integer::compareTo)
      .orElse(-1);
  }
}
