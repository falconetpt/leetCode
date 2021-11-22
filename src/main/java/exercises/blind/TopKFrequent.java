package exercises.blind;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TopKFrequent {
  public int[] topKFrequent(final int[] nums, final int k) {
    final var frequency = Arrays.stream(nums)
      .boxed()
      .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));


    return frequency.entrySet()
      .stream()
      .sorted((a, b) -> -a.getValue().compareTo(b.getValue()))
      .limit(k)
      .mapToInt(Map.Entry::getKey)
      .toArray();
  }
}
