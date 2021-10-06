package exercises.array;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindDuplicates {
  public List<Integer> findDuplicates(final int[] nums) {
    final var frequency = Arrays.stream(nums)
      .boxed()
      .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

    return frequency.entrySet()
      .stream()
      .filter(e -> e.getValue() > 1)
      .map(Map.Entry::getKey)
      .collect(Collectors.toList());
  }
}
